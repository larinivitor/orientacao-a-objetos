package testes;

import corredores.Luigi;
import corredores.Peach;
import item.CascoVerde;
import org.junit.jupiter.api.Test;
import pista.rainbowroad.CasaComItem;

import static org.junit.jupiter.api.Assertions.*;

class CasaComItemTest {

    @Test
    public void cairNaCasaGanhaItem() {
        CascoVerde item = new CascoVerde();
        CasaComItem casa = new CasaComItem(1, item);
        Peach peach = new Peach();

        casa.adicionarCorredor(peach);

        assertEquals(item, peach.getItemEquipado());
    }

    @Test
    public void segundoACairNaCasaNaoPegaItem() {
        CascoVerde item = new CascoVerde();
        CasaComItem casa = new CasaComItem(1, item);
        Peach peach = new Peach();
        Luigi luigi = new Luigi();

        casa.adicionarCorredor(peach);
        casa.adicionarCorredor(luigi);

        assertNull(luigi.getItemEquipado());
    }
}

