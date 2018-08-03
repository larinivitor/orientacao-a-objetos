package testes;

import corredores.Bowser;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class BowserTest {

    @Test
    public void anda1CasaNasDuasPrimeirasVezesQueAndar() throws CorredorNaoEstaNaPistaException {
        DonutPlains donutPlains = new DonutPlains();
        Bowser bowser = new Bowser();

        donutPlains.adicionarCorredor(bowser);

        bowser.andar();

        CasaDaPista casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(bowser);

        assertEquals(1, casaOndeCorredorEsta.getNumeroDaCasa());
    }

    @Test
    public void anda2CasasAMaisDepoisDaSegundaVez() throws CorredorNaoEstaNaPistaException {
        DonutPlains donutPlains = new DonutPlains();
        Bowser bowser = new Bowser();
        CasaDaPista casaOndeCorredorEsta = null;

        donutPlains.adicionarCorredor(bowser);

        bowser.andar();
        casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(1, casaOndeCorredorEsta.getNumeroDaCasa());

        bowser.andar();
        casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(2, casaOndeCorredorEsta.getNumeroDaCasa());

        bowser.andar();
        casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(7, casaOndeCorredorEsta.getNumeroDaCasa());
    }
}

