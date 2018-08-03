package jogo.itens.municoes;

import jogo.inventarios.InventarioDeItens;
import jogo.itens.Item;

public class Municao extends Item {

    private int quantidade;

    public Municao(int altura, int largura, int peso, int quantidade) {
        super(altura, largura, peso);
        this.quantidade = quantidade;
    }

    public int usar(int quantidadeDesejada) {
        int quantidadeASerUsada = Math.min(quantidadeDesejada, this.quantidade);
        this.quantidade -= quantidadeASerUsada;

        if (this.quantidade == 0) {
            this.removerseDeInventarioVinculado();
        }

        return quantidadeASerUsada;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    private void removerseDeInventarioVinculado() {
        InventarioDeItens inventarioDeItens = this.getInventarioDeItensQueEstaVinculado();

        if (inventarioDeItens != null) {
            inventarioDeItens.removerItem(this);
        }
    }
}
