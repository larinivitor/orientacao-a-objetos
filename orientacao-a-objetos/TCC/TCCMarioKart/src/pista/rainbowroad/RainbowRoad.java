package pista.rainbowroad;

import pista.CasaDaPista;
import pista.Pista;

import java.util.List;

public class RainbowRoad extends Pista {

    public RainbowRoad(CasaDaPista[] casasCustomizadas) {
        super(25);

        this.configurarCasasCustomizadas(casasCustomizadas);
    }

    private void configurarCasasCustomizadas(CasaDaPista[] casasCustomizadas) {
        CasaDaPista[] casasDaPista = this.getCasasDaPista();

        for (CasaDaPista casa : casasCustomizadas) {
            casasDaPista[casa.getNumeroDaCasa()] = casa;
        }
    }
}
