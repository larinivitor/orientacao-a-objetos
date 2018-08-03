package aula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RelogioTest {
    @Test
    void testarRetornarMinutosEmHorasRetornando2HorasE40Minutos(){
        //Arrange
        Relogio relogio = new Relogio();
        String esperado = "2 Horas e 40 Minutos";
        //Act
        String retorno = relogio.transformarMinutosEmHoras(160);
        //Assert
        assertEquals(esperado, retorno);
    }
    @Test
    void testarRetornarMinutosEmHorasRetornando0HorasE40Minutos(){
        //Arrange
        Relogio relogio = new Relogio();
        String esperado = "0 Horas e 40 Minutos";
        //Act
        String retorno = relogio.transformarMinutosEmHoras(40);
        //Assert
        assertEquals(esperado, retorno);
    }
    @Test
    void testarRetornarSegundosEmHorasRetornando2HorasE40Minutos(){
        //Arrange
        Relogio relogio = new Relogio();
        String esperado = "2 Horas e 40 Minutos";
        //Act
        String retorno = relogio.transformarSegundosEmHoras(9600);
        //Assert
        assertEquals(esperado, retorno);
    }
    @Test
    void testarRetornarSegundosEmHorasRetornando0HorasE40Minutos(){
        //Arrange
        Relogio relogio = new Relogio();
        String esperado = "0 Horas e 40 Minutos";
        //Act
        String retorno = relogio.transformarSegundosEmHoras(2400);
        //Assert
        assertEquals(esperado, retorno);
    }
}
