package Jogo.Ordenacao;

import Jogo.Item;

public class EstrategiaDeOrdenacaoPorNome extends EstrategiaDeOrdenacao {

    @Override
    protected boolean itemAMaiorQueB(Item itemA, Item itemB) {
        return itemA.getNome()
                .compareToIgnoreCase(itemB.getNome())
                > 0;
    }
}
