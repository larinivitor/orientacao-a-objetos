import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademiaArcanaTest {

    @Test
    public void magoQueTreinouNaAcademiaArcanaSobe1Nivel() {
        MagoArcano magoArcano = new MagoArcano();
        AcademiaArcana academiaArcana = new AcademiaArcana();

        magoArcano.treinarNaAcademiaArcana(academiaArcana);

        int nivelEsperado = 2;
        int nivelObtido = magoArcano.getNivel();

        assertEquals(nivelEsperado, nivelObtido);
    }

    @Test
    public void magoQueTreinou3VezesNaAcademiaArcanaTemBonusDe5() {
        MagoArcano magoArcano = new MagoArcano();
        AcademiaArcana academiaArcana = new AcademiaArcana();

        magoArcano.treinarNaAcademiaArcana(academiaArcana);
        magoArcano.treinarNaAcademiaArcana(academiaArcana);
        magoArcano.treinarNaAcademiaArcana(academiaArcana);

        int poderEsperado = 21; // 16 poder + 5 bonus
        int poderObtido = magoArcano.getPoderMagico();

        assertEquals(poderEsperado, poderObtido);
    }

    @Test
    public void magoQueTreinou5VezesNaAcademiaArcanaTemMesmoBonusDe3() {
        MagoArcano magoArcano = new MagoArcano();
        AcademiaArcana academiaArcana = new AcademiaArcana();

        magoArcano.treinarNaAcademiaArcana(academiaArcana);
        magoArcano.treinarNaAcademiaArcana(academiaArcana);
        magoArcano.treinarNaAcademiaArcana(academiaArcana);

        int poderEsperado = 21; // 16 poder + 5 bonus
        int poderObtido = magoArcano.getPoderMagico();

        assertEquals(poderEsperado, poderObtido);

        magoArcano.treinarNaAcademiaArcana(academiaArcana);
        magoArcano.treinarNaAcademiaArcana(academiaArcana);

        poderEsperado = 69; // 64 poder + 5 bonus
        poderObtido = magoArcano.getPoderMagico();

        assertEquals(poderEsperado, poderObtido);
    }
}