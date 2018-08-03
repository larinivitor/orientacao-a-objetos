package testes;

import estruturas.Muro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuroTest {

    @Test
    public void testarMuroRecebendoUmAtaqueDePoder100(){
        //Arrange
        Muro muro = new Muro();
        int valorDefesaEsperado = 9900;
        //Act
        muro.receberAtaque(100);
        //Assert
        assertEquals(valorDefesaEsperado, muro.getDefesa());
    }
}
