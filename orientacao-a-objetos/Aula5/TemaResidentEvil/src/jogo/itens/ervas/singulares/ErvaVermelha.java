package jogo.itens.ervas.singulares;

import jogo.itens.ervas.combinada.ErvaCombinada;
import jogo.itens.ervas.combinada.ErvaCombinadaMista;
import jogo.itens.ervas.combinada.ErvaCombinadaVermelha;

public class ErvaVermelha extends Erva {

    public ErvaVermelha() {
        super(1, 2, 1);
    }

    @Override
    protected ErvaCombinada montarMistura(Erva ervaASerCombinada) {
        if (ervaASerCombinada instanceof ErvaVermelha) {
            return new ErvaCombinadaVermelha();
        }
        else if (ervaASerCombinada instanceof ErvaVerde) {
            return new ErvaCombinadaMista();
        }

        return null;
    }
}
