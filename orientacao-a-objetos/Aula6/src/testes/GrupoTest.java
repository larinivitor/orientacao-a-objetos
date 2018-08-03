package testes;

import alvos.RaidBoss;
import org.junit.jupiter.api.Test;
import party.Grupo;
import personagem.Elfo;
import personagem.Humano;
import personagem.Orc;
import personagem.Personagem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest {
    @Test
    public void testarAtaqueSomenteComHumanosAtingindoSomentePontosDefesa(){
        //Arrange
        Personagem orc = new Orc("Fausto", 100, true);
        Personagem elfo = new Elfo("Yan", 100, 100);
        Personagem humano = new Humano("Adrian", 100, true);
        RaidBoss raidBoss = new RaidBoss(1000, "Zaia", 1000);
        Grupo grupo = new Grupo();
        //Act
        grupo.adicionarPersonagem(orc);
        grupo.adicionarPersonagem(elfo);
        grupo.adicionarPersonagem(humano);
        grupo.atacarSomenteComHumanos(raidBoss);
        //Assert
        assertEquals(700, raidBoss.getPontosDefesa());
        assertEquals(1000, raidBoss.getPontosVida());
    }
    @Test
    public void testarAtaqueOrdenadoZerandoSomentePontosDefesa(){
        //Arrange
        Personagem orc = new Orc("Fausto", 100, true);
        Personagem elfo = new Elfo("Yan", 100, 100);
        Personagem humano = new Humano("Adrian", 100, true);
        RaidBoss raidBoss = new RaidBoss(1000, "Zaia", 1000);
        List<Personagem> personagemList = new ArrayList<Personagem>();
        personagemList.add(orc);
        personagemList.add(elfo);
        personagemList.add(humano);

        Grupo grupo = new Grupo();
        //Act
        grupo.adicionarListaPersonagens(personagemList);
        grupo.atacarOrdenado(raidBoss);
        //Assert
        assertEquals(0, raidBoss.getPontosDefesa());
        assertEquals(1000, raidBoss.getPontosVida());
    }
    @Test
    public void testarAtaqueOrdenadoZerandoPontosVida(){
        //Arrange
        Personagem orc = new Orc("Fausto", 100, true);
        Personagem elfo = new Elfo("Yan", 100, 100);
        Personagem humano = new Humano("Adrian", 100, true);
        RaidBoss raidBoss = new RaidBoss(1000, "Zaia", 1000);
        List<Personagem> personagemList = new ArrayList<Personagem>();
        personagemList.add(orc);
        personagemList.add(elfo);
        personagemList.add(humano);

        Grupo grupo = new Grupo();
        //Act
        grupo.adicionarListaPersonagens(personagemList);
        grupo.atacarOrdenado(raidBoss);
        grupo.atacarOrdenado(raidBoss);
        //Assert
        assertEquals(0,raidBoss.getPontosVida());
    }
    @Test
    public void testarAtaqueSimplesZerandoPontosVida(){
        //Arrange
        Personagem orc = new Orc("Fausto", 100, true);
        Personagem elfo = new Elfo("Yan", 100, 100);
        Personagem humano = new Humano("Adrian", 100, true);
        RaidBoss raidBoss = new RaidBoss(1000, "Zaia", 1000);
        List<Personagem> personagemList = new ArrayList<Personagem>();
        personagemList.add(orc);
        personagemList.add(elfo);
        personagemList.add(humano);

        Grupo grupo = new Grupo();
        //Act
        grupo.adicionarListaPersonagens(personagemList);
        grupo.atacarSimples(raidBoss);
        grupo.atacarSimples(raidBoss);
        //Assert
        assertEquals(0,raidBoss.getPontosVida());
    }
    @Test
    public void testarPoderAtaqueDoGrupoRetornandoMil(){
        //Arrange
        Personagem orc = new Orc("Fausto", 100, true);
        Personagem elfo = new Elfo("Yan", 100, 100);
        Personagem humano = new Humano("Adrian", 100, true);
        List<Personagem> personagemList = new ArrayList<Personagem>();
        personagemList.add(orc);
        personagemList.add(elfo);
        personagemList.add(humano);

        Grupo grupo = new Grupo();
        //Act
        grupo.adicionarListaPersonagens(personagemList);
        //Assert
        assertEquals(1000,grupo.getPoderAtaqueGrupo());
    }
}
