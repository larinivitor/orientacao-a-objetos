package pista.podium;

import corredores.Corredor;

import java.util.HashMap;
import java.util.Map;

public class Podium {
    private Map<LugarNoPodium, Corredor> posicoes;

    public Podium() {
        this.posicoes = new HashMap<>();
    }

    public Corredor getCorredorNaPosicao(LugarNoPodium lugarNoPodium) {
        if (this.posicoes.containsKey(lugarNoPodium)) {
            return this.posicoes.get(lugarNoPodium);
        }

        return null;
    }

    public void adicionarCorredor(Corredor corredor) {
        LugarNoPodium lugarNoPodium = null;

        if (!this.posicoes.containsKey(LugarNoPodium.PRIMEIRO_LUGAR)) {
            lugarNoPodium = LugarNoPodium.PRIMEIRO_LUGAR;
        }
        else if (!this.posicoes.containsKey(LugarNoPodium.SEGUNDO_LUGAR)) {
            lugarNoPodium = LugarNoPodium.SEGUNDO_LUGAR;
        }
        else if (!this.posicoes.containsKey(LugarNoPodium.TERCEIRO_LUGAR)) {
            lugarNoPodium = LugarNoPodium.TERCEIRO_LUGAR;
        }

        if (lugarNoPodium != null) {
            this.posicoes.put(lugarNoPodium, corredor);
        }
    }

    public boolean corredorEstaNoPodium(Corredor corredor) {
        for (LugarNoPodium lugarNoPodium : this.posicoes.keySet()) {
            if (this.posicoes.get(lugarNoPodium) == corredor) {
                return true;
            }
        }

        return false;
    }
}
