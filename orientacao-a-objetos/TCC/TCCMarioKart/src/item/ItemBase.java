package item;

import corredores.Corredor;
import erros.ItemInvalidoException;

public abstract class ItemBase implements Item {

    private Corredor corredorQueEstaEquipado;

    @Override
    public void vincularAoCorredor(Corredor corredor) {
        this.corredorQueEstaEquipado = corredor;
    }

    public void desvincularDoCorredor() {
        this.corredorQueEstaEquipado = null;
    }

    protected Corredor getCorredorQueEstaEquipado() {
        return this.corredorQueEstaEquipado;
    }
}
