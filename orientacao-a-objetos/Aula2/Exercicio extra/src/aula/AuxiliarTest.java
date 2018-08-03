package aula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuxiliarTest {

    @Test
    void testarAdicionarPrefixo() {
        //Arrange
        String esperado = "Crescer 2018/1 Orientação a Objetos";
        Auxiliar auxiliar = new Auxiliar();
        //Act
        String retorno = auxiliar.adicionarPrefixo("Crescer 2018/1","Orientação a Objetos");
        //Assert
        assertEquals(esperado, retorno);
    }

    @Test
    void testarAdicionarSufixo() {
        //Arrange
        String esperado = "Sou participante do Crescer 2018/1";
        Auxiliar auxiliar = new Auxiliar();
        //Act
        String retorno = auxiliar.adicionarSufixo("Crescer 2018/1", "Sou participante do");
        //Assert
        assertEquals(esperado, retorno);
    }

    @Test
    void testarAdicionarPrefixoAndSufixo() {
        //Arrange
        String esperado = "Instrutor Giordano Crescer 2018/1";
        Auxiliar auxiliar = new Auxiliar();
        //Act
        String retorno = auxiliar.adicionarPrefixoAndSufixo("Instrutor Giordano", "2018/1", "Crescer");
        //Assert
        assertEquals(esperado, retorno);
    }
}