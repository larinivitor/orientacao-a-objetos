package testes;

import corredores.Mario;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class MarioTest {

    @Test
    public void marioComecaCom7DeVida() {
        Mario mario = new Mario();

        assertEquals(7, mario.getVida());
    }

    @Test
    public void marioAnda4Casas() throws CorredorNaoEstaNaPistaException {
        DonutPlains donutPlains = new DonutPlains();
        Mario mario = new Mario();

        donutPlains.adicionarCorredor(mario);

        mario.andar();

        CasaDaPista casaDaPista = donutPlains.getCasaOndeCorredorEsta(mario);

        assertEquals(4, casaDaPista.getNumeroDaCasa());
    }
}

