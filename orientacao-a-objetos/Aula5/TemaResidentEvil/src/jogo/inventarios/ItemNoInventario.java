package jogo.inventarios;

import jogo.itens.Item;

import java.util.List;

public class ItemNoInventario {
    private Item item;
    private List<BlocoDeInventario> blocosOcupados;

    public ItemNoInventario(Item item, List<BlocoDeInventario> blocosOcupados) {
        this.item = item;
        this.blocosOcupados = blocosOcupados;
    }

    public Item getItem() {
        return item;
    }

    public List<BlocoDeInventario> getBlocosOcupados() {
        return blocosOcupados;
    }
}
