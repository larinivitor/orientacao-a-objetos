package jogo.itens.municoes._testes;

import jogo.inventarios.InventarioDeItens;
import jogo.itens.municoes.Municao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MunicaoTest {

    @Test
    public void usarMunicaoReduzQuantidadeAtual() {
        Municao municao = new Municao(2, 2, 1, 10);

        municao.usar(4);

        assertEquals(6, municao.getQuantidade());
    }

    @Test
    public void municaoQuandoAcabaRemoveDoInventario() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(1, 1);
        Municao municao = new Municao(1, 1, 1, 1);

        inventarioDeItens.adicionarItem(municao);

        assertTrue(inventarioDeItens.itemEstaNoInventario(municao));

        municao.usar(1);

        assertFalse(inventarioDeItens.itemEstaNoInventario(municao));
    }

}