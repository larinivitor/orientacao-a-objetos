package testes;

import corredores.Luigi;
import corredores.Peach;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.rainbowroad.CasaComBuraco;
import pista.rainbowroad.RainbowRoad;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CasaComBuracoTest {
    @Test
    public void cairNaCasaNumero5Causa3DeDano() {
        Luigi luigi = new Luigi();
        CasaComBuraco casaComBuraco = new CasaComBuraco(5);

        assertEquals(5, luigi.getVida());

        casaComBuraco.adicionarCorredor(luigi);

        assertEquals(2, luigi.getVida());
    }

    @Test
    public void passarPeloBuracoSemCairNeleNaoCausaDano() throws CorredorNaoEstaNaPistaException {
        Peach peach = new Peach();
        CasaDaPista[] casasCustomizadas = { new CasaComBuraco(2) };
        RainbowRoad rainbowRoad = new RainbowRoad(casasCustomizadas);

        rainbowRoad.adicionarCorredor(peach);

        assertEquals(6, peach.getVida());

        peach.andar();

        assertEquals(6, peach.getVida());
    }
}

