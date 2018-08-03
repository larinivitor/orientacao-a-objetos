package jogo.itens.armas._testes;

import jogo.inventarios.InventarioDeItens;
import jogo.itens.armas.Bazuca;
import jogo.itens.municoes.MissilBazuca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BazucaTest {

    @Test
    public void aposAtirarMissilSaiDoInventario() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(10, 10);
        Bazuca bazuca = new Bazuca();
        MissilBazuca missilBazuca = new MissilBazuca();

        inventarioDeItens.adicionarItem(bazuca);
        inventarioDeItens.adicionarItem(missilBazuca);

        assertTrue(inventarioDeItens.itemEstaNoInventario(missilBazuca));

        bazuca.atirar(missilBazuca);

        assertFalse(inventarioDeItens.itemEstaNoInventario(missilBazuca));
    }

}