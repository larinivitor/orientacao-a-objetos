package jogo.inventarios._testes;

import jogo.inventarios.InventarioDeItens;
import jogo.itens.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarioDeItensTest {

    @Test
    public void inventario4x4Tem16BlocosLivres() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(4, 4);

        assertEquals(16, inventarioDeItens.getNumeroDeEspacosDisponiveis());
    }

    @Test
    public void inventarioTem2BlocosLivresDepoisDeAdicionarItem() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(2, 2);
        Item item = new Item(1,2, 1);

        inventarioDeItens.adicionarItem(item);

        assertEquals(2, inventarioDeItens.getNumeroDeEspacosDisponiveis());
    }

    @Test
    public void item2x2CabeEmInventario3x3() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(3, 3);
        Item item = new Item(2,2,1);

        assertTrue(inventarioDeItens.itemCabeNoInventario(item));
    }

    @Test
    public void item4x4NaoCabeNoInventario4x3() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(4, 3);
        Item item = new Item(4,4,1);

        assertFalse(inventarioDeItens.itemCabeNoInventario(item));
    }

    @Test
    public void itemSoCabeNoInventarioDepoisDeRotacionado() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(2, 5);
        Item item = new Item(4, 1, 4);

        assertFalse(inventarioDeItens.itemCabeNoInventario(item));

        item.rotacionar();

        assertTrue(inventarioDeItens.itemCabeNoInventario(item));
    }

    @Test
    public void doisItens1x1CabemEmInventario2x1() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(2, 1);
        Item itemA = new Item(1,1,1);
        Item itemB = new Item(1,1,1);

        inventarioDeItens.adicionarItem(itemA);

        assertTrue(inventarioDeItens.itemCabeNoInventario(itemB));
    }

    @Test
    public void doisItens2x2NaoCabemEmInventario3x3() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(3,3);
        Item itemA = new Item(2,2,1);
        Item itemB = new Item(2,2,1);

        inventarioDeItens.adicionarItem(itemA);

        assertFalse(inventarioDeItens.itemCabeNoInventario(itemB));
    }

    @Test
    public void itemBSoCabeDepoisDeRotacionadoPoisItemAOcupaEspaco() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(4,4);

        Item itemA = new Item(3,2,1);
        Item itemB = new Item(2, 4, 1);

        inventarioDeItens.adicionarItem(itemA);

        assertFalse(inventarioDeItens.itemCabeNoInventario(itemB));

        itemB.rotacionar();

        assertTrue(inventarioDeItens.itemCabeNoInventario(itemB));
    }

    @Test
    public void inventarioCheioNaoPodeAdicionarItemNenhum() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(10, 10);
        Item itemGigante = new Item(10, 10, 100);
        Item flauta = new Item(1, 1, 1);

        inventarioDeItens.adicionarItem(itemGigante);

        assertFalse(inventarioDeItens.itemCabeNoInventario(flauta));
    }

    @Test
    public void itensComTamanhoCorretoEnchemInventario() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(9, 1);
        Item chaveDePrata = new Item(3, 1, 0.1);
        Item chaveDeOuro = new Item(3, 1, 0.1);
        Item chaveDeDiamante = new Item(3, 1, 0.1);

        inventarioDeItens.adicionarItem(chaveDePrata);
        inventarioDeItens.adicionarItem(chaveDeOuro);
        inventarioDeItens.adicionarItem(chaveDeDiamante);

        assertEquals(0, inventarioDeItens.getNumeroDeEspacosDisponiveis());
    }

    @Test
    public void removerItemDesocupaEspacoDoInventario() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(2, 2);
        Item item = new Item(1, 1, 1);

        inventarioDeItens.adicionarItem(item);

        assertEquals(3, inventarioDeItens.getNumeroDeEspacosDisponiveis());

        inventarioDeItens.removerItem(item);

        assertEquals(4, inventarioDeItens.getNumeroDeEspacosDisponiveis());
    }

    @Test
    public void itemComMaiorAreaEhEncontradoNoInventario() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(5,5);
        Item chave = new Item(1, 1, 0.1);
        Item martelo = new Item(2, 4, 2);
        Item carta = new Item(2, 2, 0.1);

        inventarioDeItens.adicionarItem(chave);
        inventarioDeItens.adicionarItem(martelo);
        inventarioDeItens.adicionarItem(carta);

        assertEquals(martelo, inventarioDeItens.getItemQueOcupaMaisEspaco());
    }

    @Test
    public void inventarioVazioNaoRetornaItemDeMaiorArea() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(5,5);

        assertEquals(null, inventarioDeItens.getItemQueOcupaMaisEspaco());
    }

    @Test
    public void inventarioComPesoTotal10() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(5, 5);
        Item machado = new Item(2, 5, 10);

        inventarioDeItens.adicionarItem(machado);

        assertEquals(10, inventarioDeItens.getPesoTotalCarregado());
    }

    @Test
    public void inventarioComDoisItensDePeso3Pesa6() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(5, 5);
        Item machadinho = new Item(1, 3, 3);
        Item espadinha = new Item(1, 3, 3);

        inventarioDeItens.adicionarItem(machadinho);
        inventarioDeItens.adicionarItem(espadinha);

        assertEquals(6, inventarioDeItens.getPesoTotalCarregado());
    }

    @Test
    public void mesmoItemNaoPodeSerAdicionadoDuasVezes() {

    }
}













