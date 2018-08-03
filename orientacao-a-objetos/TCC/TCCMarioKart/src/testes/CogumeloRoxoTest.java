package testes;

import corredores.Luigi;
import erros.CorredorNaoEstaNaPistaException;
import erros.ItemInvalidoException;
import item.CogumeloRoxo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CogumeloRoxoTest {

    @Test
    public void adiciona2PontosDeVidaAoCorredor() throws ItemInvalidoException, CorredorNaoEstaNaPistaException {
        Luigi luigi = new Luigi();
        CogumeloRoxo cogumeloRoxo = new CogumeloRoxo();

        luigi.equiparItem(cogumeloRoxo);

        assertEquals(5, luigi.getVida());

        luigi.usarItem(cogumeloRoxo);

        assertEquals(7, luigi.getVida());
    }
}

