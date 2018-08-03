package testes;

import corredores.Luigi;
import erros.CorredorNaoEstaNaPistaException;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class LuigiTest {

    @Test
    public void luigiAnda3CasasNaDonutPlains() throws CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        DonutPlains donutPlains = new DonutPlains();

        donutPlains.adicionarCorredor(luigi);

        luigi.andar();

        CasaDaPista casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(3, casaOndeCorredorEsta.getNumeroDaCasa());
    }

    @Test
    public void luigiTemVida5() {
        Luigi luigi = new Luigi();
        assertEquals(5, luigi.getVida());
    }

    @Test
    public void luigiAnda6CasasQuandoAndaDuasVezesNaDonutPlains() throws CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        DonutPlains donutPlains = new DonutPlains();

        donutPlains.adicionarCorredor(luigi);

        luigi.andar();
        luigi.andar();

        CasaDaPista casaOndeCorredorEsta = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(6, casaOndeCorredorEsta.getNumeroDaCasa());
    }
}