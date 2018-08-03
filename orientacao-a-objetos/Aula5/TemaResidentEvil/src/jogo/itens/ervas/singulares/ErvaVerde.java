package jogo.itens.ervas.singulares;

import jogo.itens.ervas.combinada.ErvaCombinada;
import jogo.itens.ervas.combinada.ErvaCombinadaMista;
import jogo.itens.ervas.combinada.ErvaCombinadaVerde;

public class ErvaVerde extends Erva {

    public ErvaVerde() {
        super(1, 2, 1);
    }


    @Override
    protected ErvaCombinada montarMistura(Erva ervaASerCombinada) {
        if (ervaASerCombinada instanceof ErvaVerde) {
            return new ErvaCombinadaVerde();
        }
        else if (ervaASerCombinada instanceof ErvaVermelha) {
            return new ErvaCombinadaMista();
        }

        return null;
    }
}
