package testes;

import item.CascoAzul;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.rainbowroad.CasaComBuraco;
import pista.rainbowroad.CasaComItem;
import pista.rainbowroad.CasaComTurbo;
import pista.rainbowroad.RainbowRoad;

import static org.junit.jupiter.api.Assertions.*;

class RainbowRoadTest {
    @Test
    public void asCasasIniciaisSaoCustomizadas() {
        CasaDaPista[] casasCustomizadas = new CasaDaPista[] {
                new CasaComBuraco(1),
                new CasaComTurbo(2),
                new CasaComItem(3, new CascoAzul())
        };

        RainbowRoad rainbowRoad = new RainbowRoad(casasCustomizadas);

        CasaDaPista[] casasDaPista = rainbowRoad.getCasasDaPista();

        assertTrue(casasDaPista[1] instanceof  CasaComBuraco);
        assertTrue(casasDaPista[2] instanceof  CasaComTurbo);
        assertTrue(casasDaPista[3] instanceof  CasaComItem);
    }
}