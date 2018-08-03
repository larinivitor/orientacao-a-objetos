package testes;

import corredores.Bowser;
import corredores.Luigi;
import corredores.Mario;
import corredores.Peach;
import erros.AlvoInvalidoException;
import erros.CorredorNaoEstaNaPistaException;
import erros.ItemInvalidoException;
import item.CascoAzul;
import item.Cogumelo;
import org.junit.jupiter.api.Test;
import pista.donutplains.DonutPlains;

import static org.junit.jupiter.api.Assertions.*;

class CascoAzulTest {

    @Test
    public void atacarAlvoQueNaoEstaEmPrimeiroLugarRetornaErro() {
        Luigi luigi = new Luigi();
        Mario mario = new Mario();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(mario);

        CascoAzul cascoAzul = new CascoAzul();

        luigi.equiparItem(cascoAzul);

        assertThrows(AlvoInvalidoException.class, () -> {
           luigi.usarItem(cascoAzul, mario);
        });
    }

    @Test
    public void atacarAlvoEmPrimeiroDeveAcertarMarioECausar4DeDano() throws AlvoInvalidoException, ItemInvalidoException, CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        Peach peach = new Peach();
        Mario mario = new Mario();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(peach);
        donutPlains.adicionarCorredor(mario);

        peach.andar();
        mario.andar();

        CascoAzul cascoAzul = new CascoAzul();
        luigi.equiparItem(cascoAzul);

        assertEquals(7, mario.getVida());

        luigi.usarItem(cascoAzul, mario);

        assertEquals(3, mario.getVida());
    }

    @Test
    public void acertarAlvoA1CasaDeDistanciaCausa1DeDano() throws AlvoInvalidoException, ItemInvalidoException, CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        Bowser bowser = new Bowser();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(bowser);

        bowser.andar();

        CascoAzul cascoAzul = new CascoAzul();
        luigi.equiparItem(cascoAzul);

        luigi.usarItem(cascoAzul, bowser);

        assertEquals(9, bowser.getVida());
    }

    @Test
    public void acertaTodosQueEstiveremEmPrimeiroLugar() throws ItemInvalidoException, AlvoInvalidoException, CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        Mario mario = new Mario();
        Peach peach = new Peach();
        Bowser bowser = new Bowser();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(peach);
        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(bowser);

        Cogumelo cogumelo = new Cogumelo();
        mario.equiparItem(cogumelo);
        mario.usarItem(cogumelo);
        peach.equiparItem(cogumelo);
        peach.usarItem(cogumelo);

        bowser.andar();

        CascoAzul cascoAzul = new CascoAzul();
        luigi.equiparItem(cascoAzul);

        assertEquals(7, mario.getVida());
        assertEquals(6, peach.getVida());
        assertEquals(10, bowser.getVida());

        luigi.usarItem(cascoAzul, peach);

        assertEquals(3, mario.getVida());
        assertEquals(2, peach.getVida());
        assertEquals(10, bowser.getVida());
    }

}
