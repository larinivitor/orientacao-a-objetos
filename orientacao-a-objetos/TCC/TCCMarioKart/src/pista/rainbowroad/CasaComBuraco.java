package pista.rainbowroad;

import corredores.Corredor;
import pista.CasaDaPista;

public class CasaComBuraco extends CasaDaPista {

    public CasaComBuraco(int numeroDaCasa) {
        super(numeroDaCasa);
    }

    @Override
    public void adicionarCorredor(Corredor corredor) {
        super.adicionarCorredor(corredor);

        corredor.perderVida(this.getDanoAoCairNaCasa());
    }

    private int getDanoAoCairNaCasa() {
        return (int) Math.ceil((double)this.getNumeroDaCasa() / 2.0);
    }
}
