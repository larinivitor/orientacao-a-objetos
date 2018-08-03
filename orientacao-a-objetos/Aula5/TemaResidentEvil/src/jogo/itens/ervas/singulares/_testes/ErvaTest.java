package jogo.itens.ervas.singulares._testes;

import jogo.itens.ervas.singulares.Erva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErvaTest {

    @Test
    public void ervaNaoPodeSerCombinadaConsigoMesma() {
        Erva erva = new Erva(1, 1, 1);

        assertNull(erva.combinar(erva));
    }

}