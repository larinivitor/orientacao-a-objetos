package jogo.inventarios;

import jogo.itens.Item;

public class BlocoDeInventario {
    private int linha;
    private int coluna;

    private Item[][] blocosAQueEstaVinculado;
    private Item itemDentroDoBloco;

    public BlocoDeInventario(Item[][] blocosAQueEstaVinculado, int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.blocosAQueEstaVinculado = blocosAQueEstaVinculado;
        this.itemDentroDoBloco = blocosAQueEstaVinculado[linha][coluna];
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public Item getItemDentroDoBloco() {
        return itemDentroDoBloco;
    }

    public boolean estaVazio() {
        return this.itemDentroDoBloco == null;
    }

    public void ocuparComItem(Item item) {
        this.itemDentroDoBloco = item;
        this.blocosAQueEstaVinculado[this.getLinha()][this.getColuna()] = item;
    }

    public void esvaziar() {
        this.ocuparComItem(null);
    }
}
