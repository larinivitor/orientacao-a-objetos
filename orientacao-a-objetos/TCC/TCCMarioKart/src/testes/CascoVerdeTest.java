package testes;

import corredores.Bowser;
import corredores.Luigi;
import corredores.Mario;
import erros.AlvoInvalidoException;
import erros.ItemInvalidoException;
import item.CascoVerde;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CascoVerdeTest {

    @Test
    public void lancarCascoVerdeTira3DeVida() throws AlvoInvalidoException, ItemInvalidoException {
        Luigi luigi = new Luigi();
        Bowser bowser = new Bowser();

        CascoVerde cascoVerde = new CascoVerde();
        luigi.equiparItem(cascoVerde);

        assertEquals(10, bowser.getVida());

        luigi.usarItem(cascoVerde, bowser);

        assertEquals(7, bowser.getVida());
    }

    @Test
    public void naoPodeLancarCascoVerdeEmSiMesmo() {
        assertThrows(AlvoInvalidoException.class, () -> {
            Luigi luigi = new Luigi();
            CascoVerde cascoVerde = new CascoVerde();

            luigi.equiparItem(cascoVerde);
            luigi.usarItem(cascoVerde, luigi);
        });
    }
}

