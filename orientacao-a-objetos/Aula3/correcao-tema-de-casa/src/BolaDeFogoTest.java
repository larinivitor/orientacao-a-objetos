import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BolaDeFogoTest {

    @Test
    public void bolaDeFogoTemPoder10() {
        BolaDeFogo bolaDeFogo = new BolaDeFogo(5, 4, 1);

        int poderEsperado = 10;
        int poderObtido = bolaDeFogo.getPoder();

        assertEquals(poderEsperado, poderObtido);
    }
}