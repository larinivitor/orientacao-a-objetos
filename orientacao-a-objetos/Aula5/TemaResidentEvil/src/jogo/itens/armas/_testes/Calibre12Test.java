package jogo.itens.armas._testes;

import jogo.itens.armas.Calibre12;
import jogo.itens.municoes.MunicaoCalibre12;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calibre12Test {

    @Test
    public void ficaSemMunicaoAposAtirar() {
        Calibre12 calibre12 = new Calibre12();

        calibre12.atirar();

        assertEquals(0, calibre12.getMunicaoAtual());
    }

    @Test
    public void recarregarCalibre12Gasta2PorVez() {
        Calibre12 calibre12 = new Calibre12();
        MunicaoCalibre12 municaoCalibre12 = new MunicaoCalibre12();

        calibre12.atirar();

        calibre12.recarregar(municaoCalibre12);

        assertEquals(2, calibre12.getMunicaoAtual());
        assertEquals(6, municaoCalibre12.getQuantidade());
    }

}