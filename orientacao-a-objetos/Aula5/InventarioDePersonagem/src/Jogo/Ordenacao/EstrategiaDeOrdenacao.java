package Jogo.Ordenacao;

import Jogo.Item;

import java.util.Arrays;
import java.util.List;

public class EstrategiaDeOrdenacao {

    public List<Item> ordenar(List<Item> itens) {
        // converte a lista em array
        Item[] itensOrdenados = new Item[itens.size()];
        itensOrdenados = itens.toArray(itensOrdenados);

        int numeroDeItens = itensOrdenados.length;

        for (int i = 0; i < numeroDeItens; i++) {
            for (int j = 0; j < numeroDeItens - 1; j++) {
                Item itemA = itensOrdenados[j];
                Item itemB = itensOrdenados[j + 1];

                if (this.itemAMaiorQueB(itemA, itemB)) {
                    itensOrdenados[j] = itemB;
                    itensOrdenados[j + 1] = itemA;
                }
            }
        }

        return Arrays.asList(itensOrdenados);
    }

    protected boolean itemAMaiorQueB(Item itemA, Item itemB) {
        return true;
    }
}
