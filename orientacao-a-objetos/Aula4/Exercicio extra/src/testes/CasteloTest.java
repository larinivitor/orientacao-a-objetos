package testes;

import armas.Ariete;
import armas.Arma;
import armas.Catapulta;
import estruturas.Castelo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasteloTest {
    @Test
    public void testarCasteloRecebendoAtaqueArmaAereaPerdendoDano(){
        //Arrange
        Arma catapulta = new Catapulta("Catapulta Senior", 250);
        Castelo castelo = new Castelo("Celta");
        int defesaCasteloRestante = 46000;
        //Act
        castelo.receberAtaque(catapulta);
        //Assert
        assertEquals(defesaCasteloRestante, castelo.getPontosDefesa());
    }
    @Test
    public void testarCasteloRecebendoAtaqueArmaTerrestrePerdendoDanoSomenteMuro(){
        //Arrange
        Arma ariete = new Ariete("Ariete ponta de ferro", true);
        Castelo castelo = new Castelo("Celta");
        int defesaCasteloRestante = 50000;
        //Act
        castelo.receberAtaque(ariete);
        //Assert
        assertEquals(defesaCasteloRestante, castelo.getPontosDefesa());
    }
    @Test
    public void testarCasteloRecebendoAtaqueArmaTerrestrePerdendoDano(){
        //Arrange
        Arma ariete = new Ariete("Ariete ponta de ferro", true);
        Castelo castelo = new Castelo("Celta");
        int defesaCasteloRestante = 49000;
        //Act
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        //Assert
        assertEquals(defesaCasteloRestante, castelo.getPontosDefesa());
    }
    @Test
    public void testarCasteloRecebendoAtaqueArmaNormalPerdendoDanoSomenteMuro(){
        //Arrange
        Arma espada = new Arma("Espada");
        Castelo castelo = new Castelo("Celta");
        int defesaCasteloRestante = 50000;
        //Act
        castelo.receberAtaque(espada);
        //Assert
        assertEquals(defesaCasteloRestante, castelo.getPontosDefesa());
    }
    @Test
    public void testarCasteloRecebendoAtaqueArmaNormalPerdendoDano(){
        //Arrange
        Arma espada = new Arma("Espada");
        Castelo castelo = new Castelo("Celta");
        int defesaCasteloRestante = 49980;
        //Act
        for(int i = 0; i < 501; i++){
            castelo.receberAtaque(espada);
        }
        int poder = espada.getPoderAtaque();

        //Assert
        assertEquals(defesaCasteloRestante, castelo.getPontosDefesa());
    }

    @Test
    public void testarCasteloRecebendoAtaqueSemSerDestruido(){
        //Arrange
        Arma catapulta = new Catapulta("Super Catapulta Senior", 5000);
        Castelo castelo = new Castelo("Celta");
        boolean casteloDestruido = false;
        //Act
        castelo.receberAtaque(catapulta);
        castelo.receberAtaque(catapulta);
        //Assert
        assertEquals(casteloDestruido, castelo.getDestruido());
    }
    @Test
    public void testarCasteloRecebendoAtaqueAteSerDestruido(){
        //Arrange
        Arma catapulta = new Catapulta("Super Catapulta Senior", 5000);
        Castelo castelo = new Castelo("Celta");
        boolean casteloDestruido = true;
        //Act
        castelo.receberAtaque(catapulta);
        castelo.receberAtaque(catapulta);
        castelo.receberAtaque(catapulta);
        castelo.receberAtaque(catapulta);
        //Assert
        assertEquals(casteloDestruido, castelo.getDestruido());
    }
}
