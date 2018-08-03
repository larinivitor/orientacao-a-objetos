package testes;

import corredores.Peach;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class PeachTest {

    @Test
    public void peachGanhaBonusDe2CasasQuandoAndaPelaTerceiraVez() throws CorredorNaoEstaNaPistaException {
        DonutPlains donutPlains = new DonutPlains();
        Peach peach = new Peach();

        donutPlains.adicionarCorredor(peach);

        CasaDaPista casaOndeCorredorEsta = null;

        peach.andar();
        casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(peach);
        assertEquals(3, casaOndeCorredorEsta.getNumeroDaCasa());

        peach.andar();
        casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(peach);
        assertEquals(6, casaOndeCorredorEsta.getNumeroDaCasa());

        peach.andar();
        casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(peach);
        assertEquals(11, casaOndeCorredorEsta.getNumeroDaCasa());
    }
}

