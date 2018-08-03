package testes;

import corredores.Luigi;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.rainbowroad.CasaComTurbo;
import pista.rainbowroad.RainbowRoad;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CasaComTurboTest {

    @Test
    public void corredorQueCaiNaCasaAndaUmaVezAdicional() throws CorredorNaoEstaNaPistaException {
        CasaComTurbo casaComTurbo = new CasaComTurbo(3);
        CasaDaPista[] casasCustomizadas = { casaComTurbo };

        RainbowRoad rainbowRoad = new RainbowRoad(casasCustomizadas);
        Luigi luigi = new Luigi();

        rainbowRoad.adicionarCorredor(luigi);

        luigi.andar();

        CasaDaPista casaOndeLuigiEsta = rainbowRoad.getCasaOndeCorredorEsta(luigi);

        assertEquals(6, casaOndeLuigiEsta.getNumeroDaCasa());
    }
}

