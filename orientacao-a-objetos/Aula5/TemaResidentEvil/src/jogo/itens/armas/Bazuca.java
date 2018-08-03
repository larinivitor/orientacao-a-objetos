package jogo.itens.armas;

import jogo.itens.armas.Arma;
import jogo.itens.municoes.MissilBazuca;

public class Bazuca extends Arma {

    public Bazuca() {
        super(4, 10, 5.0, 0, 1);
    }

    public void atirar(MissilBazuca missilBazuca) {
        missilBazuca.usar(1);
    }
}
