package Jogo.Ordenacao;

import Jogo.Item;

public class EstrategiaDeOrdenacaoPorValor extends EstrategiaDeOrdenacao {

    @Override
    protected boolean itemAMaiorQueB(Item itemA, Item itemB) {
        return itemA.getValor() > itemB.getValor();
    }
}
