package Jogo.Pocoes;

import Jogo.InventarioDeItens;
import Jogo.Item;

public class Pocao extends Item {

    private int doses;
    private int pontosDeEfeito;

    public Pocao(String nome, double valor, int doses, int pontosDeEfeito) {
        super(nome, valor, doses * 0.1);

        this.doses = doses;
        this.pontosDeEfeito = pontosDeEfeito;
    }

    public void gastarDose() {
        this.doses -= 1;

        if (this.doses < 1) {
            this.getInventarioDeItensAQuePertence().removerItem(this);
        }
    }
}
