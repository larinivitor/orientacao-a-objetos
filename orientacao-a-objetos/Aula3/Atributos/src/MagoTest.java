import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagoTest {

    @Test
    public void magoDeveIniciarComNivel1() {
        Mago mago = new Mago();

        int nivelEsperado = 1;
        int nivelObtido = mago.getNivel();

        assertEquals(nivelEsperado, nivelObtido);
    }

    @Test
    public void magoQueSubiuParaNivel2TemVida14() {
        Mago mago = new Mago();
        mago.passarDeNivel();

        int vidaEsperada = 14;
        int vidaObtida = mago.getVida();

        assertEquals(vidaEsperada, vidaObtida);
    }

    @Test
    public void magoComVidaAlteradaPropositalmenteTemVida5() {
        Mago mago = new Mago();

        mago.setVida(5);

        int vidaEsperada = 5;
        int vidaObtida = mago.getVida();

        assertEquals(vidaEsperada, vidaObtida);
    }

    @Test
    public void magoQueNaoExiste() {
        Mago mago = null;

        // java.lang.NullPointerException
        mago.passarDeNivel();
    }
}












