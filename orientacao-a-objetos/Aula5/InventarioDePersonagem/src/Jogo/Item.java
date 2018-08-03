package Jogo;

public class Item {
    private String nome;
    private double valor;
    private double peso;

    private InventarioDeItens inventarioDeItensAQuePertence;

    public Item(String nome, double valor, double peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public boolean estaEmUmInventario() {
        return this.inventarioDeItensAQuePertence != null;
    }

    public void vincularAInventario(InventarioDeItens inventarioDeItens) {
        this.inventarioDeItensAQuePertence = inventarioDeItens;
    }

    public InventarioDeItens getInventarioDeItensAQuePertence() {
        return inventarioDeItensAQuePertence;
    }
}
