package jogo.inventarios;

import jogo.itens.Item;

import java.util.LinkedList;
import java.util.List;

public class InventarioDeItens {

    /***
     * Aqui está a matriz do inventário (dã)
     */
    private Item[][] matrizDoInventario;

    /**
     * Criamos, além de uma matriz, uma lista para filtrarmos
     * mais facilmente os itens.
     * Usaremos esta lista para buscar por um item ou somar
     * os pesos, etc.
     */
    private List<ItemNoInventario> itensNoInventario;

    /**
     * Guardamos as configurações originais de linhas e colunas.
     * Assim não precisamos ficar contando a partir da matriz.
     */
    private int linhas;
    private int colunas;


    public InventarioDeItens(int largura, int altura) {
        this.matrizDoInventario = new Item[largura][altura];
        this.linhas = largura;
        this.colunas = altura;

        this.itensNoInventario = new LinkedList<>();
    }

    public int getNumeroDeEspacosDisponiveis() {
        int blocosLivres = 0;

        // usamos um for para linha e outro para as colunas
        // precisamos percorrer toda a matriz para descobrirmos
        // quais blocos estão vazios.
        for (int linha = 0; linha < this.linhas; linha++) {
            for (int coluna = 0; coluna < this.colunas; coluna++) {
                // a classe BlocoDeInventario é uma classe utilitária
                // que nos ajuda a obter informações de cada bloco da matriz.
                BlocoDeInventario blocoDeInventario = new BlocoDeInventario(this.matrizDoInventario, linha, coluna);

                if (blocoDeInventario.estaVazio()) {
                    blocosLivres ++;
                }
            }
        }

        return blocosLivres;
    }

    public boolean itemCabeNoInventario(Item item) {
        // neste algoritimo pensamos em buscar os blocos
        // onde o item será colocado. Caso o item não caiba,
        // escolhemos retornar null.
        return this.getBlocosDisponiveisParaItem(item) != null;
    }

    public boolean adicionarItem(Item item) {
        // se o item já está no inventario, não tem o porquê
        // adicioná-lo novamente.
        if (this.itemEstaNoInventario(item)) {
            return false;
        }

        // aqui vamos obter os blocos que estão livres
        // e que o item cabe.
        List<BlocoDeInventario> blocosParaItem = this.getBlocosDisponiveisParaItem(item);

        // caso retorne null (ou seja, não encontramos nenhum lugar onde
        // tem os blocos onde cabe o item)
        // o item não poderá ser adicionado.
        if (blocosParaItem == null) {
            return false;
        }

        // após pegar os blocos livres, marcamo-os como ocupado
        // pelo item.
        for(BlocoDeInventario bloco : blocosParaItem) {
            bloco.ocuparComItem(item);
        }

        // vinculamos o item ao inventário atual.
        item.vincularAoInventario(this);

        // adicionamos o item na nossa lista paralela
        // para ficar mais fácil de obtêlo.
        // A classe ItemNoInventario é um utilitário que agrupa
        // item + blocos que ele ocupa.
        // Assim quando quisermos trabalhar com um item, já teremos
        // todas as informações sobre ele agrupados.
        this.itensNoInventario.add(new ItemNoInventario(item, blocosParaItem));

        return true;
    }

    public void removerItem(Item item) {
        // se um item não está no inventário, não tem o porquê
        // tentar removê-lo.
        if (!this.itemEstaNoInventario(item)) {
            return;
        }

        // pegamos o item que já existe no inventário.
        ItemNoInventario itemNoInventario = this.encontrarItemNoInventario(item);

        // como temos agrupado os blocos que o item ocupa,
        // basta percorrer eles e esvaziá-los um a um.
        for (BlocoDeInventario blocoDeInventario : itemNoInventario.getBlocosOcupados()) {
            blocoDeInventario.esvaziar();
        }

        // após remover os itens dos blocos, não podemos esquecer
        // de remover da lista auxiliar.
        this.itensNoInventario.remove(itemNoInventario);
    }

    public Item getItemQueOcupaMaisEspaco() {
        // se o inventário está vazio...
        if (this.itensNoInventario.size() == 0) {
            return null;
        }

        // criamos esta variável para ir armazenando
        // o item mais pesado na busca.
        Item itemComMaiorAreaEncontrada = this.itensNoInventario.get(0).getItem();

        // para verificarmos qual o mais pesado, basta ver se o segundo
        // é maior que o primeiro e ir atualizado.
        for (ItemNoInventario itemNoInventario : this.itensNoInventario) {
            if (itemNoInventario.getItem().getAreaQueOcupa() > itemComMaiorAreaEncontrada.getAreaQueOcupa()) {
                itemComMaiorAreaEncontrada = itemNoInventario.getItem();
            }
        }

        return itemComMaiorAreaEncontrada;
    }

    public double getPesoTotalCarregado() {
        double pesoTotal = 0;

        for(ItemNoInventario itemNoInventario : this.itensNoInventario) {
            pesoTotal += itemNoInventario.getItem().getPeso();
        }

        return pesoTotal;
    }

    public boolean itemEstaNoInventario(Item item) {
        return encontrarItemNoInventario(item) != null;
    }

    private ItemNoInventario encontrarItemNoInventario(Item itemASerEncontrado) {
        // como salvamos os itens em uma lista paralela,
        // basta verificar se algum dos itens da lista paralela
        // é igual ao que procuramos.
        for(ItemNoInventario itemNoInventario : this.itensNoInventario) {
            if (itemASerEncontrado == itemNoInventario.getItem()) {
                return itemNoInventario;
            }
        }

        return null;
    }


    /**
     * Aqui resolvemos buscar os blocos disponíveis para um item.
     * Ou seja, vamos ter uma lista das posições dos blocos onde o
     * item será colocado.
     */
    private List<BlocoDeInventario> getBlocosDisponiveisParaItem(Item item) {
        // percorremos as linhas e colunas da matriz.
        for (int linha = 0; linha < this.linhas; linha++) {
            for (int coluna = 0; coluna < this.colunas; coluna++) {
                // criamos a variável que representa o bloco.
                BlocoDeInventario blocoOrigem = new BlocoDeInventario(this.matrizDoInventario, linha, coluna);

                // aqui vamos montar a matriz do item com base no bloco atual do loop.
                // exemplo:
                // digamos que temos um item 2x2 e estamos na posição 0x0 da matriz.
                // então vamos obter a matriz: 0x0, 0x1, 1x0, 1x1
                List<BlocoDeInventario> matrizDeOcupacao = this.montarMatrizDeOcupacaoDeItem(item, blocoOrigem);

                // caso a matriz de ocupação seja null
                // (isso pode acontecer se o item é maior que o espaço disponível no inventário)
                // não retornamos nada, indicando que não há blocos disponíveis.
                if (matrizDeOcupacao == null) {
                    return null;
                }

                // para que os blocos encontrados para a matriz do item
                // sejam validos, eles precisam estar vazios e ter a quantidade
                // igual ao do item.
                // Um item 3x3 ocupa 9 blocos, então se encontramos 7 blocos livres
                // o item não caberá.
                boolean osBlocosSaoValidosParaOItem =
                        matrizDeOcupacao.size() == item.getAreaQueOcupa()
                        && this.osBlocosEstaoVazios(matrizDeOcupacao);

                if (osBlocosSaoValidosParaOItem) {
                    return matrizDeOcupacao;
                }
            }
        }

        return null;
    }

    private List<BlocoDeInventario> montarMatrizDeOcupacaoDeItem(Item item, BlocoDeInventario blocoOrigem) {
        // para montar a matriz do item, precisamos pegar o bloco de origem
        // (que nada mais é do que o bloco de onde partirá o cálculo de espaço do item)
        // e montar a busca por blocos daquele item.
        // Exemplo: item 2x3 (0 é o bloco origem e X é onde o item vai ocupar)
        // [ ][ ][ ][ ][ ]
        // [ ][0][X][X][ ]
        // [ ][X][X][X][ ]
        // [ ][ ][ ][ ][ ]
        // [ ][ ][ ][ ][ ]
        // a origem poderia estar em qualquer lugar que quiséssemos.

        // para esse cálculo, precisamos descobrir onde começar
        // e onde terminar tanto na linha quando na coluna.
        // este cálculo é fácil, basta pegar o bloco de origem e
        // cruzar com o tamanho do item.
        int linhaInicio = blocoOrigem.getLinha();
        int linhaFim = linhaInicio + item.getLargura();
        int colunaInicio = blocoOrigem.getColuna();
        int colunaFim = colunaInicio + item.getAltura();

        // criamos uma lista para armazenar os blocos encontrados para o item.
        List<BlocoDeInventario> blocosDoItem = new LinkedList<>();

        // temos que começar nosso loop na mesma posição de linha
        // e coluna que o bloco de origem, dai o loop
        // deve terminar onde o espaço do item acaba.
        for (int linha = linhaInicio; linha < linhaFim; linha++) {
            for (int coluna = colunaInicio; coluna < colunaFim; coluna++) {
                // este cálculo indica que o item está fora do tamanho do
                // inventário.
                // Exemplo: item 2x4 e origem está perto do fim:
                // [ ][ ][ ][ ][ ]
                // [ ][ ][0][X][X] X <<<
                // [ ][ ][X][X][X] X <<<
                // [ ][ ][ ][ ][ ]
                // [ ][ ][ ][ ][ ]
                boolean foraDaMatriz = linha >= this.linhas || coluna >= this.colunas;

                // caso esteja fora da matriz, pula pra próxima.
                if (foraDaMatriz) {
                    continue;
                }

                // caso dê tudo certo, adiciona nos blocos pro item.
                blocosDoItem.add(new BlocoDeInventario(this.matrizDoInventario, linha, coluna));
            }
        }

        return blocosDoItem;
    }

    private boolean osBlocosEstaoVazios(List<BlocoDeInventario> blocos) {
        for(BlocoDeInventario bloco : blocos) {
            if (!bloco.estaVazio()) {
                return false;
            }
        }

        return true;
    }
}












