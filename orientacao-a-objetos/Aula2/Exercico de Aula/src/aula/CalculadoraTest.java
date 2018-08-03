package aula;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    @Test
    void testarSomaRetornandoVinte() {
        //Arrange
        Calculadora calculadora = new Calculadora();
        int valorEsperado = 20;
        //Act
        int valorRetorno = calculadora.somar(10,10);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
    @Test
    void testarSubtraçãoRetornandoDez(){
        //Arrange
        Calculadora calculadora = new Calculadora();
        int valorEsperado = 10;
        //Act
        int valorRetorno = calculadora.subtrair(100, 90);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
    @Test
    void testarMultiplicacaoRetornandoCem(){
        //Arrange
        Calculadora calculadora = new Calculadora();
        double valorEsperado = 100;
        //Act
        double valorRetorno = calculadora.multiplicar(10,10);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
    @Test
    void testarDivisaoRetornandoDez(){
        //Arrange
        Calculadora calculadora = new Calculadora();
        double valorEsperado = 10;
        //Act
        double valorRetorno = calculadora.dividir(100,10);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
    @Test
    void testarDivisaoRetornandoValorQuebrado(){
        //Arrange
        Calculadora calculadora = new Calculadora();
        double valorEsperado = 10.5;
        //Act
        double valorRetorno = calculadora.dividir(21,2);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
    @Test
    void testarCalcularModuloRetornandoInteiroRetornandoZero(){
        //Arrange
        Calculadora calculadora = new Calculadora();
        double valorEsperado = 0;
        //Act
        double valorRetorno = calculadora.calcularModuloRetornandoInteiro(100,25);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
    @Test
    void testarCalcularModuloRetornandoInteiroRetornando40(){
        //Arrange
        Calculadora calculadora = new Calculadora();
        double valorEsperado = 40;
        //Act
        double valorRetorno = calculadora.calcularModuloRetornandoInteiro(100,60);
        //Assert
        assertEquals(valorEsperado, valorRetorno);
    }
}