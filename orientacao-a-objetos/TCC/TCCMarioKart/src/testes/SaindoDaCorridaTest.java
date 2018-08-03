package testes;

import corredores.Luigi;
import corredores.Mario;
import erros.AlvoInvalidoException;
import erros.ItemInvalidoException;
import item.CascoVerde;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

public class SaindoDaCorridaTest {

    @Test
    public void corredorQuePerdeTodaAVidaSaiDaCorrida() throws AlvoInvalidoException, ItemInvalidoException {
        Luigi luigi = new Luigi();
        Mario mario = new Mario();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(mario);

        CascoVerde cascoVerde = new CascoVerde();

        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde, luigi);

        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde, luigi);

        CasaDaPista casa = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertNull(casa);
    }
}
