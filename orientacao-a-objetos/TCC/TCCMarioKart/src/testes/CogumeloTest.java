package testes;

import corredores.Luigi;
import erros.CorredorNaoEstaNaPistaException;
import erros.ItemInvalidoException;
import item.Cogumelo;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class CogumeloTest {

    @Test
    public void corredorAnda4CasasQuandoUsaCogumelo() throws ItemInvalidoException, CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        DonutPlains donutPlains = new DonutPlains();
        Cogumelo cogumelo = new Cogumelo();

        donutPlains.adicionarCorredor(luigi);
        luigi.andar();

        CasaDaPista casa = donutPlains.getCasaOndeCorredorEsta(luigi);
        assertEquals(3, casa.getNumeroDaCasa());

        luigi.equiparItem(cogumelo);

        luigi.usarItem(cogumelo);

        casa = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(7, casa.getNumeroDaCasa());
    }

    @Test
    public void usarItemSemTerEquipadoGeraErro() {
        Luigi luigi = new Luigi();
        Cogumelo cogumelo = new Cogumelo();

        assertThrows(ItemInvalidoException.class, () -> {
           luigi.usarItem(cogumelo);
        });
    }
}

