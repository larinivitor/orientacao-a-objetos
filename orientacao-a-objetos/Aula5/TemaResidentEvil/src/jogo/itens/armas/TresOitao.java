package jogo.itens.armas;

import jogo.itens.armas.Arma;
import jogo.itens.municoes.MunicaoTresOitao;

public class TresOitao extends Arma {

    public TresOitao() {
        super(1, 3, 1, 8, 1);
    }


    public void recarregar(MunicaoTresOitao municaoTresOitao) {
        super.recarregar(municaoTresOitao);
    }
}
