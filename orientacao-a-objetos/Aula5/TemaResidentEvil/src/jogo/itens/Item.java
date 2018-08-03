package jogo.itens;

import jogo.inventarios.InventarioDeItens;

public class Item {
    private int altura;
    private int largura;
    private double peso;

    private InventarioDeItens inventarioDeItensQueEstaVinculado;

    public Item(int largura, int altura, double peso) {
        this.altura = altura;
        this.largura = largura;
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getAreaQueOcupa() {
        return largura * altura;
    }

    public double getPeso() {
        return peso;
    }

    public InventarioDeItens getInventarioDeItensQueEstaVinculado() {
        return inventarioDeItensQueEstaVinculado;
    }

    public void rotacionar() {
        int aux = this.largura;
        this.largura = this.altura;
        this.altura = aux;
    }

    public void vincularAoInventario(InventarioDeItens inventarioDeItens) {
        this.inventarioDeItensQueEstaVinculado = inventarioDeItens;
    }
}
