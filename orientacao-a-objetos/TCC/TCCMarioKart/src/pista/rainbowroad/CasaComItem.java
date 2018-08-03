package pista.rainbowroad;

import corredores.Corredor;
import erros.CorredorNaoEstaNaPistaException;
import item.Item;
import pista.CasaDaPista;

public class CasaComItem extends CasaDaPista {

    private Item itemNaCasa;

    public CasaComItem(int numeroDaCasa, Item itemNaCasa) {
        super(numeroDaCasa);

        this.itemNaCasa = itemNaCasa;
    }

    @Override
    public void adicionarCorredor(Corredor corredor) {
        super.adicionarCorredor(corredor);

        if (this.itemNaCasa == null) {
            return;
        }

        corredor.equiparItem(this.itemNaCasa);
        this.itemNaCasa = null;
    }
}
