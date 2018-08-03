package Jogo.Ordenacao;

import Jogo.Item;

public class EstrategiaDeOrdenacaoPorPeso extends EstrategiaDeOrdenacao {

    @Override
    protected boolean itemAMaiorQueB(Item itemA, Item itemB) {
        return itemA.getPeso() > itemB.getPeso();
    }
}
