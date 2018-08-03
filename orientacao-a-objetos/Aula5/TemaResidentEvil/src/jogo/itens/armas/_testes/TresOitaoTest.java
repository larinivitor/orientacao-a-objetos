package jogo.itens.armas._testes;

import jogo.itens.armas.TresOitao;
import jogo.itens.municoes.MunicaoTresOitao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TresOitaoTest {

    @Test
    public void tresOitaoFicaCom7DeMunicaoAposPrimeiroTiro() {
        TresOitao tresOitao = new TresOitao();

        tresOitao.atirar();

        assertEquals(7, tresOitao.getMunicaoAtual());
    }

    @Test
    public void tresOitaoFicaCom0MunicaoDepoisDeAtirar20Vezes() {
        TresOitao tresOitao = new TresOitao();

        for (int i = 0; i < 20; i++) {
            tresOitao.atirar();
        }

        assertEquals(0, tresOitao.getMunicaoAtual());
    }

    @Test
    public void recarregarMunicaoEncheTambor() {
        MunicaoTresOitao municaoTresOitao = new MunicaoTresOitao();
        TresOitao tresOitao = new TresOitao();

        tresOitao.atirar();

        assertEquals(7, tresOitao.getMunicaoAtual());

        tresOitao.recarregar(municaoTresOitao);

        assertEquals(8, tresOitao.getMunicaoAtual());
        assertEquals(19, municaoTresOitao.getQuantidade());
    }

    @Test
    public void recarregarMenosDoQueMunicaoDisponivel() {
        MunicaoTresOitao municaoTresOitao = new MunicaoTresOitao();
        TresOitao tresOitao = new TresOitao();

        // retira 18 unidades da munição
        municaoTresOitao.usar(18);

        for (int i = 0; i < 5; i++) {
            tresOitao.atirar();
        }

        tresOitao.recarregar(municaoTresOitao);

        assertEquals(5, tresOitao.getMunicaoAtual());
        assertEquals(0, municaoTresOitao.getQuantidade());
    }
}