package item;

import corredores.Corredor;
import erros.AlvoInvalidoException;

public class CascoVerde extends ItemBase implements ItemDeAtaque {

    @Override
    public void atacar(Corredor corredorAlvo) throws AlvoInvalidoException {
        corredorAlvo.perderVida(3);
    }
}
