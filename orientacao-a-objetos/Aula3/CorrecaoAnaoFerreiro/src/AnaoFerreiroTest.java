import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnaoFerreiroTest {

    @Test
    public void anaoNivel5ForjaMachadoComNivel5() {
        AnaoFerreiro anaoFerreiro = new AnaoFerreiro(90, 5);

        Machado machado = anaoFerreiro.forjarMachado();

        int poderMachadoEsperado = 5;
        int poderMachadoObtido = machado.getPoder();

        assertEquals(poderMachadoEsperado, poderMachadoObtido);
    }


    @Test
    public void anaoNivel5Com120AnosForjaMachadoComNivel7() {
        AnaoFerreiro anaoFerreiro = new AnaoFerreiro(120, 5);

        Machado machado = anaoFerreiro.forjarMachado();

        int poderMachadoEsperado = 7;
        int poderMachadoObtido = machado.getPoder();

        assertEquals(poderMachadoEsperado, poderMachadoObtido);
    }

    @Test
    public void anaoNivel21Com170AnosForjaMachadoComNivel23() {
        AnaoFerreiro anaoFerreiro = new AnaoFerreiro(170, 21);

        Machado machado = anaoFerreiro.forjarMachado();

        int poderMachadoEsperado = 23;
        int poderMachadoObtido = machado.getPoder();

        assertEquals(poderMachadoEsperado, poderMachadoObtido);
    }

    @Test
    public void anaoComNivel2NaoPodeMelhorarMachados() {
        AnaoFerreiro anaoFerreiro = new AnaoFerreiro(160, 2);

        boolean esperado = false;
        boolean obtido = anaoFerreiro.podeMelhorarMachado();

        assertEquals(esperado, obtido);
    }

    @Test
    public void anaoComIdade200ENivel6ConcedeMelhoria2() {
        AnaoFerreiro anaoFerreiro = new AnaoFerreiro(200, 6);

        int melhoriaEsperada = 2;
        int melhoriaObtida = anaoFerreiro.getBonusDeMelhoriaParaMachado();

        assertEquals(melhoriaEsperada, melhoriaObtida);
    }
}





