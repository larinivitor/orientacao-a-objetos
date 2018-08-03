package testes;

import corredores.Bowser;
import corredores.Luigi;
import erros.AlvoInvalidoException;
import erros.CorredorNaoEstaNaPistaException;
import erros.ItemInvalidoException;
import item.Baletao;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class BaletaoTest {

    @Test
    public void baletaoAnda7Casas() throws ItemInvalidoException, CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        Baletao baletao = new Baletao();
        DonutPlains donutPlains = new DonutPlains();

        donutPlains.adicionarCorredor(luigi);

        luigi.equiparItem(baletao);
        luigi.usarItem(baletao);

        CasaDaPista casa = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(7, casa.getNumeroDaCasa());
    }

    @Test
    public void baletaoCausa5PontosDeDano() throws AlvoInvalidoException, ItemInvalidoException {
        Luigi luigi = new Luigi();
        Bowser bowser = new Bowser();
        Baletao baletao = new Baletao();

        assertEquals(10, bowser.getVida());

        luigi.equiparItem(baletao);
        luigi.usarItem(baletao, bowser);

        assertEquals(5, bowser.getVida());
    }
}

