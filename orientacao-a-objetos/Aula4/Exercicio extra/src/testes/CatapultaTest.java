package testes;

import armas.Arma;
import armas.Catapulta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {

    @Test
    public void testarPoderAtaqueCatapultaComZeroDeAltura(){
        //Arrange
        Arma catapulta = new Catapulta("Catapulta Junior", 0);
        int poderEsperado = 3500;
        //Act
        int poderRetornado = catapulta.getPoderAtaque();
        //Assert
        assertEquals(poderEsperado, poderRetornado);
    }

    @Test
    public void testarPoderAtaqueCatapultaCom100DeAlturaDeAtaque(){
        //Arrange
        Arma catapulta = new Catapulta("Catapulta Senior", 100);
        int poderEsperado = 3700;
        //Act
        int poderRetornado = catapulta.getPoderAtaque();
        //Assert
        assertEquals(poderEsperado, poderRetornado);
    }
    @Test
    public void testarTipoAriete(){
        //Arrange
        Arma catapulta = new Catapulta("Cata", 100);
        String esperado = "aereo";
        //Act
        String retornado = catapulta.getTipoAtaque();
        //Assert
        assertEquals(esperado, retornado);
    }
}
