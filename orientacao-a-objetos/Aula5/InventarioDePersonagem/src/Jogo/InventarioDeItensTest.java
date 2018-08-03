package Jogo;

import Jogo.Equipamentos.Armadura;
import Jogo.Equipamentos.Equipamento;
import Jogo.Equipamentos.Espada;
import Jogo.Pocoes.PocaoDeCura;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventarioDeItensTest {

    @Test
    public void inventarioDeveTerEspadaDepoisDeAdicionar() {
        Espada espada = new Espada();
        InventarioDeItens inventarioDeItens = new InventarioDeItens();

        inventarioDeItens.adicionarItem(espada);

        Espada espadaNoInventario =
                (Espada) inventarioDeItens.getListaDeItens().get(0);

        assertEquals(espadaNoInventario, espada);
    }

    @Test
    public void filtrarEquipamentosRetornaSomenteArmadura() {
        Armadura armadura = new Armadura();
        PocaoDeCura pocaoDeCura = new PocaoDeCura(1);
        InventarioDeItens inventarioDeItens = new InventarioDeItens();

        inventarioDeItens.adicionarItem(armadura);
        inventarioDeItens.adicionarItem(pocaoDeCura);

        List<Equipamento> equipamentos = inventarioDeItens.getEquipamentos();

        assertEquals(1, equipamentos.size());
        assertEquals(equipamentos.get(0), armadura);
    }

    @Test
    public void itemAdicionadoAoInventarioEstaVinculado() {
        Espada espada = new Espada();
        InventarioDeItens inventarioDeItens = new InventarioDeItens();

        inventarioDeItens.adicionarItem(espada);

        assertEquals(inventarioDeItens, espada.getInventarioDeItensAQuePertence());
    }
}



















