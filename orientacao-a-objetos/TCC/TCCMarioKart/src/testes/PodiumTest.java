package testes;

import corredores.Luigi;
import corredores.Mario;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.donutplains.DonutPlains;
import pista.podium.LugarNoPodium;

import static org.junit.jupiter.api.Assertions.*;

class PodiumTest {
    @Test
    public void corredorVaiParaPodiumAposTerminarCorrida() throws CorredorNaoEstaNaPistaException {
        DonutPlains donutPlains = new DonutPlains();
        Luigi luigi = new Luigi();

        donutPlains.adicionarCorredor(luigi);

        for (int i = 0; i < 7; i++) {
            luigi.andar();
        }

        assertEquals(luigi, donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.PRIMEIRO_LUGAR));
    }

    @Test
    public void corredorTerminaEmSegundoLugar() throws CorredorNaoEstaNaPistaException {
        DonutPlains donutPlains = new DonutPlains();
        Luigi luigi = new Luigi();
        Mario mario = new Mario();

        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(mario);

        for (int i = 0; i < 7; i++) {
            luigi.andar();
        }

        for (int i = 0; i < 5; i++) {
            mario.andar();
        }

        assertEquals(luigi, donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.PRIMEIRO_LUGAR));
        assertEquals(mario, donutPlains.getPodium().getCorredorNaPosicao(LugarNoPodium.SEGUNDO_LUGAR));
    }
}




