package Jogo.Equipamentos;

import Jogo.InventarioDeItens;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspadaTest {
    
    @Test
    public void espadaUsada12VezesQuebra() {
        Espada espada = new Espada();
        InventarioDeItens inventarioDeItens = new InventarioDeItens();
        
        inventarioDeItens.adicionarItem(espada);

        for (int i = 0; i < 12; i++) {
            espada.usar();
        }

        assertEquals(0,
                inventarioDeItens.getListaDeItens().size());
    }

}









