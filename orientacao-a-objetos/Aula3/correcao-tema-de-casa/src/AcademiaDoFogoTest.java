import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademiaDoFogoTest {

    @Test
    public void magoQueNaoTreinouNaAcademiaDoFogoNaoSabeLancarBolaDeFogo() {
        MagoArcano magoArcano = new MagoArcano();

        BolaDeFogo esperado = null;
        BolaDeFogo obtido = magoArcano.lancarBolaDeFogo(1);

        assertEquals(esperado, obtido);
    }

    @Test
    public void magoNivel1EAcademiaDoFogoNivel2PodeLancarBolaDeFogoComPoder8() {
        MagoArcano magoArcano = new MagoArcano();
        AcademiaDoFogo academiaDoFogo = new AcademiaDoFogo(2);

        magoArcano.treinarNaAcademiaDoFogo(academiaDoFogo);

        int poderBolaDeFogoEsperado = 8;
        int poderBolaDeFogoObtido = magoArcano.lancarBolaDeFogo(4).getPoder();

        assertEquals(poderBolaDeFogoEsperado, poderBolaDeFogoObtido);
    }

    @Test
    public void magoQueLancarBolaDeFogoComMaisMagiaQueTemSofreLimitacaoDePoder() {
        MagoArcano magoArcano = new MagoArcano();
        AcademiaDoFogo academiaDoFogo = new AcademiaDoFogo(2);

        magoArcano.treinarNaAcademiaDoFogo(academiaDoFogo);

        int poderBolaDeFogoEsperado = 8;
        int poderBolaDeFogoObtido = magoArcano.lancarBolaDeFogo(10).getPoder();

        assertEquals(poderBolaDeFogoEsperado, poderBolaDeFogoObtido);
    }

    @Test
    public void magoPerdePontosDeManaQuandoLancaMagia() {
        MagoArcano magoArcano = new MagoArcano();
        AcademiaDoFogo academiaDoFogo = new AcademiaDoFogo(2);

        magoArcano.treinarNaAcademiaDoFogo(academiaDoFogo);

        magoArcano.lancarBolaDeFogo(1);

        int manaEsperada = 3;
        int manaObtida = magoArcano.getMana();

        assertEquals(manaEsperada, manaObtida);
    }
}














