package Jogo.Pocoes;

import Jogo.InventarioDeItens;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PocaoDeCuraTest {

    @Test
    public void pocaoCom1DoseSaiDoInventarioQuandoUsada() {
        PocaoDeCura pocaoDeCura = new PocaoDeCura(1);
        InventarioDeItens inventarioDeItens = new InventarioDeItens();

        inventarioDeItens.adicionarItem(pocaoDeCura);

        assertEquals(pocaoDeCura,
                inventarioDeItens.getListaDeItens().get(0));

        pocaoDeCura.gastarDose();

        assertEquals(0,
                inventarioDeItens.getListaDeItens().size());
    }

}