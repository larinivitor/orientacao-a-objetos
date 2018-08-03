package aula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraInteligenteTest {

    @Test
    void testarApresentarSoma() {
        //Arrange
        Calculadora calculadora = new Calculadora();
        Auxiliar auxiliar = new Auxiliar();
        CalculadoraInteligente calculadorInteligente = new CalculadoraInteligente();
        String esperado = "Resultado da soma: 5";
        //Act
        String resultado = calculadorInteligente.apresentarSoma(calculadora, auxiliar, 2,3);
        //Assert
        assertEquals(esperado, resultado);
    }
    @Test
    void testarApresentarDivisao() {
        //Arrange
        Calculadora calculadora = new Calculadora();
        Auxiliar auxiliar = new Auxiliar();
        CalculadoraInteligente calculadorInteligente = new CalculadoraInteligente();
        String esperado = "Resultado da divisão: 11.5";
        //Act
        String resultado = calculadorInteligente.apresentarDivisao(calculadora, auxiliar, 23,2);
        //Assert
        assertEquals(esperado, resultado);
    }
    @Test
    void testarApresentarSubtracao() {
        //Arrange
        Calculadora calculadora = new Calculadora();
        Auxiliar auxiliar = new Auxiliar();
        CalculadoraInteligente calculadorInteligente = new CalculadoraInteligente();
        String esperado = "Resultado da subtração: 5";
        //Act
        String resultado = calculadorInteligente.apresentarSubtracao(calculadora, auxiliar, 10,5);
        //Assert
        assertEquals(esperado, resultado);
    }
    @Test
    void testarApresentarMultiplicacao() {
        //Arrange
        Calculadora calculadora = new Calculadora();
        Auxiliar auxiliar = new Auxiliar();
        CalculadoraInteligente calculadorInteligente = new CalculadoraInteligente();
        String esperado = "Resultado da multiplicação: 100.0";
        //Act
        String resultado = calculadorInteligente.apresentarMultiplicacao(calculadora, auxiliar, 4,25);
        //Assert
        assertEquals(esperado, resultado);
    }
}