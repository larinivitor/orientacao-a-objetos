package testes;

import armas.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArieteTest {
    @Test
    public void testarPoderAtaqueArieteComPontaDeFerro(){
        //Arrange
        Arma ariete = new Ariete("Ariete campeão", true);
        int poderAtaqueEsperado = 1000;
        //Act
        int retornoAtaque = ariete.getPoderAtaque();
        //Assert
        assertEquals(poderAtaqueEsperado, retornoAtaque);
    }
    @Test
    public void testarPoderAtaqueArieteSemPontaDeFerro(){
        //Arrange
        Arma ariete = new Ariete("Ariete campeão", false);
        int poderAtaqueEsperado = 500;
        //Act
        int retornoAtaque = ariete.getPoderAtaque();
        //Assert
        assertEquals(poderAtaqueEsperado, retornoAtaque);
    }
    @Test
    public void testarTipoAriete(){
        //Arrange
        Arma ariete = new Ariete("Ariete", true);
        String esperado = "terrestre";
        //Act
        String retornado = ariete.getTipoAtaque();
        //Assert
        assertEquals(esperado, retornado);
    }
}
