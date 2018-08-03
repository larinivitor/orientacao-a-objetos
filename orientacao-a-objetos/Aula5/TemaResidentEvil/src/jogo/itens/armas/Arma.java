package jogo.itens.armas;

import jogo.itens.Item;
import jogo.itens.municoes.Municao;

public class Arma extends Item {

    private int quantidadeMaximaDeMunicao;
    private int tirosPorVez;

    private int municaoAtual;


    public Arma(int altura, int largura, double peso, int quantidadeMaximaDeMunicao, int tirosPorVez) {
        super(altura, largura, peso);

        this.quantidadeMaximaDeMunicao = quantidadeMaximaDeMunicao;
        this.tirosPorVez = tirosPorVez;

        this.municaoAtual = quantidadeMaximaDeMunicao;
    }

    public void atirar() {
        int tirosADisparar = Math.min(this.municaoAtual, this.tirosPorVez);
        this.municaoAtual -= tirosADisparar;
    }

    public int getMunicaoAtual() {
        return municaoAtual;
    }

    protected void recarregar(Municao municao) {
        int quantidadeDesejadaDeMunicao = this.quantidadeMaximaDeMunicao - this.municaoAtual;

        int quantidadeDisponivelParaRecarga = Math.min(quantidadeDesejadaDeMunicao, municao.getQuantidade());

        this.municaoAtual += municao.usar(quantidadeDisponivelParaRecarga);
    }
}
