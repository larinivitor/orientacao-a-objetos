package testes;

import org.junit.jupiter.api.Test;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DonutPlainsTest {

    @Test
    public void deveComecarCom20Casas() {
        DonutPlains donutPlains = new DonutPlains();

        assertEquals(20, donutPlains.getCasasDaPista().length);
    }
}