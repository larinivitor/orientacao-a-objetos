package item;

import corredores.Corredor;
import erros.AlvoInvalidoException;

public class Baletao extends ItemBase implements ItemDeAtaque, ItemDeBonus {

    @Override
    public void atacar(Corredor corredorAlvo) throws AlvoInvalidoException {
        corredorAlvo.perderVida(5);
    }

    @Override
    public int getValorBonus() {
        return 7;
    }
}
