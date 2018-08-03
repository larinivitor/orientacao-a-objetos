import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmaTest {

    @Test
    public void atirarComArmaPerde1Municao() throws SemMunicaoExtraException, ArmaSemMunicaoException {
        Arma arma = new Arma();

        arma.atirar();
    }

    @Test
    public void atirar7BalasTemMunicaoExtra() throws SemMunicaoExtraException, ArmaSemMunicaoException {
        Arma arma = new Arma();

        for (int i = 0; i < 7; i++) {
            arma.atirar();
        }
    }

    @Test
    public void armaSemMunicaoResultaEmErro() {
        assertThrows(SemMunicaoExtraException.class, () -> {
            Arma arma = new Arma();

            for (int i = 0; i < 40; i++) {
                arma.atirar();
            }
        });
    }

    @Test
    public void aposAtirarENaoTerMunicaoRecarrega() {
        Arma arma = new Arma();

        try {
            for (int i = 0; i < 10; i++) {
                arma.atirar();
            }
        } catch (ArmaSemMunicaoException semMunicaoEx) {
            assertEquals("Oops, sem balas.", semMunicaoEx.getMessage());


            try {
                arma.recarregar();
            } catch (SemMunicaoExtraException semMunicaoExtraEx) {
                //

            }
        }

    }

    @Test
    public void tstNull() {
        Arma arma = null;

        try {
            arma.atirar();
        } catch (ArmaSemMunicaoException ex) {

        } catch (NullPointerException nullEx) {

        } catch (StackOverflowError error) {

        }


    }
}










