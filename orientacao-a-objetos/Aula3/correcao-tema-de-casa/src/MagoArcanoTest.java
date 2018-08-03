import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagoArcanoTest {

    @Test
    public void magoDeveDobrarAtributosQuandoSobeDeNivel() {
        MagoArcano magoArcano = new MagoArcano();

        magoArcano.subirDeNivel();

        assertEquals(2, magoArcano.getNivel());
        assertEquals(20, magoArcano.getVida());
        assertEquals(4, magoArcano.getPoderMagico());
        assertEquals(8, magoArcano.getMana());
    }

    @Test
    public void magoDeveDobrarAtributosDuasVezesQuandoSobe2Niveis() {
        MagoArcano magoArcano = new MagoArcano();

        magoArcano.subirDeNivel();
        magoArcano.subirDeNivel();

        assertEquals(3, magoArcano.getNivel());
        assertEquals(40, magoArcano.getVida());
        assertEquals(8, magoArcano.getPoderMagico());
        assertEquals(16, magoArcano.getMana());
    }
}