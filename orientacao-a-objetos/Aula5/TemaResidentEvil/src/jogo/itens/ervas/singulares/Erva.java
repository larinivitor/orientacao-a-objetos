package jogo.itens.ervas.singulares;

import jogo.inventarios.InventarioDeItens;
import jogo.itens.Item;
import jogo.itens.ervas.combinada.ErvaCombinada;

public class Erva extends Item {

    public Erva(int largura, int altura, double peso) {
        super(largura, altura, peso);
    }

    public final ErvaCombinada combinar(Erva erva) {
        if (erva == this) {
            return null;
        }

        ErvaCombinada resultado = this.montarMistura(erva);

        if (resultado == null) {
            return null;
        }

        InventarioDeItens inventarioVinculado = this.getInventarioDeItensQueEstaVinculado();
        if (inventarioVinculado == null) {
            return resultado;
        }

        inventarioVinculado.removerItem(this);
        inventarioVinculado.removerItem(erva);
        inventarioVinculado.adicionarItem(resultado);

        return resultado;
    }

    protected ErvaCombinada montarMistura(Erva ervaASerCombinada) {
        return null;
    }
}
