package jogo.itens.ervas.singulares._testes;

import jogo.inventarios.InventarioDeItens;
import jogo.itens.ervas.combinada.ErvaCombinada;
import jogo.itens.ervas.combinada.ErvaCombinadaMista;
import jogo.itens.ervas.combinada.ErvaCombinadaVerde;
import jogo.itens.ervas.singulares.ErvaVerde;
import jogo.itens.ervas.singulares.ErvaVermelha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErvaVerdeTest {

    @Test
    public void combinacaoResultaEmErvaCombinadaVerde() {
        ErvaVerde ervaVerde1 = new ErvaVerde();
        ErvaVerde ervaVerde2 = new ErvaVerde();

        ErvaCombinada ervaCombinada = ervaVerde1.combinar(ervaVerde2);

        assertTrue(ervaCombinada instanceof ErvaCombinadaVerde);
    }

    @Test
    public void ervasSomemDoInventarioDepoisDeCombinadasEErvaCombinadaEhAdicionada() {
        InventarioDeItens inventarioDeItens = new InventarioDeItens(10, 10);

        ErvaVerde ervaVerde1 = new ErvaVerde();
        ErvaVerde ervaVerde2 = new ErvaVerde();

        inventarioDeItens.adicionarItem(ervaVerde1);
        inventarioDeItens.adicionarItem(ervaVerde2);

        ErvaCombinada ervaCombinada = ervaVerde1.combinar(ervaVerde2);

        assertTrue(inventarioDeItens.itemEstaNoInventario(ervaCombinada));
        assertFalse(inventarioDeItens.itemEstaNoInventario(ervaVerde1));
        assertFalse(inventarioDeItens.itemEstaNoInventario(ervaVerde2));
    }

    @Test
    public void combinacaoComErvaVermelhaResultaEmMista() {
        ErvaVerde ervaVerde = new ErvaVerde();
        ErvaVermelha ervaVermelha = new ErvaVermelha();

        ErvaCombinada ervaCombinada = ervaVerde.combinar(ervaVermelha);

        assertTrue(ervaCombinada instanceof ErvaCombinadaMista);
    }
}