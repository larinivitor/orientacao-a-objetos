package testes;

import armas.Arma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaTest {
    @Test
    public void armaSimplesDeveInicairCom20Ataque(){
        //Arrange
        Arma arma = new Arma("Arma Simples");
        int poderEsperado = 20;
        //Act
        int poderRetornado = arma.getPoderAtaque();
        //Assert
        assertEquals(poderEsperado, poderRetornado);
    }
    @Test
    public void armaSimplesDeveTerTipoAtaqueNormal(){
        //Arrange
        Arma arma = new Arma("Arma Simples");
        String tipoArma = "normal";
        //Act
        String tipoAtaqueRetornado = arma.getTipoAtaque();
        //Assert
        assertEquals(tipoArma, tipoAtaqueRetornado);
    }
}
