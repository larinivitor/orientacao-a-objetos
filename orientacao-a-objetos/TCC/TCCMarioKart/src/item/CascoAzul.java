package item;

import corredores.Corredor;
import erros.AlvoInvalidoException;
import pista.CasaDaPista;
import pista.Pista;

import java.util.List;

public class CascoAzul extends ItemBase implements ItemDeAtaque {

    private Pista pistaEmQueFoiAdquirido;

    public CascoAzul() {
    }

    @Override
    public void vincularAoCorredor(Corredor corredor) {
        super.vincularAoCorredor(corredor);
        this.pistaEmQueFoiAdquirido = corredor.getPistaEmQueEstaCorrendo();
    }

    @Override
    public void atacar(Corredor corredorAlvo) throws AlvoInvalidoException {
        if (!this.alvoEstaEmPrimeiroLugar(corredorAlvo)) {
            throw new AlvoInvalidoException();
        }

        CasaDaPista casaDaPista = this.pistaEmQueFoiAdquirido.getCasaOndeCorredorEsta(corredorAlvo);

        for(Corredor corredor : casaDaPista.getCorredores()) {
            corredor.perderVida(this.getPoderDeAtaque(corredorAlvo));
        }
    }

    private int getPoderDeAtaque(Corredor alvo) {
        CasaDaPista casaOndeItemEsta = this.pistaEmQueFoiAdquirido.getCasaOndeCorredorEsta(this.getCorredorQueEstaEquipado());
        CasaDaPista casaAlvo = this.pistaEmQueFoiAdquirido.getCasaOndeCorredorEsta(alvo);

        return casaAlvo.getNumeroDaCasa() - casaOndeItemEsta.getNumeroDaCasa();
    }

    private CasaDaPista getCasaOndeCorredoresEstaoEmPrimeiroLugar() {
        CasaDaPista[] casaDaPistas = this.pistaEmQueFoiAdquirido.getCasasDaPista();

        for (int i = casaDaPistas.length - 1; i > 0; i--) {
            CasaDaPista casaDaPista = casaDaPistas[i];

            if (casaDaPista.getCorredores().size() > 0) {
                return casaDaPista;
            }
        }

        return casaDaPistas[0];
    }

    private boolean alvoEstaEmPrimeiroLugar(Corredor alvo) {
        CasaDaPista casaEmPrimeiroLugarComCorredores = this.getCasaOndeCorredoresEstaoEmPrimeiroLugar();

        return casaEmPrimeiroLugarComCorredores.corredorEstaNestaCasa(alvo)
                && !casaEmPrimeiroLugarComCorredores.corredorEstaNestaCasa(this.getCorredorQueEstaEquipado());
    }
}
