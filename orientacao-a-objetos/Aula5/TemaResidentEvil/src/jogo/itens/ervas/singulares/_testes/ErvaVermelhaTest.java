package jogo.itens.ervas.singulares._testes;

import jogo.itens.ervas.combinada.ErvaCombinada;
import jogo.itens.ervas.combinada.ErvaCombinadaMista;
import jogo.itens.ervas.combinada.ErvaCombinadaVermelha;
import jogo.itens.ervas.singulares.ErvaVerde;
import jogo.itens.ervas.singulares.ErvaVermelha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErvaVermelhaTest {

    @Test
    public void ervaCombinadaResultaEmErvaCombinadaVermelha() {
        ErvaVermelha ervaVermelha1 = new ErvaVermelha();
        ErvaVermelha ervaVermelha2 = new ErvaVermelha();

        ErvaCombinada ervaCombinada = ervaVermelha1.combinar(ervaVermelha2);

        assertTrue(ervaCombinada instanceof ErvaCombinadaVermelha);
    }

    @Test
    public void combinacaoComErvaVerdeResultaEmMista() {
        ErvaVermelha ervaVermelha = new ErvaVermelha();
        ErvaVerde ervaVerde = new ErvaVerde();

        ErvaCombinada ervaCombinada = ervaVermelha.combinar(ervaVerde);

        assertTrue(ervaCombinada instanceof ErvaCombinadaMista);
    }
}