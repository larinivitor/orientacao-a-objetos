package item;

import corredores.Corredor;
import erros.AlvoInvalidoException;

public interface ItemDeAtaque extends Item {
    void atacar(Corredor corredorAlvo) throws AlvoInvalidoException;
}
