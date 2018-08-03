package testes;

import corredores.Corredor;
import erros.CorredorNaoEstaNaPistaException;
import item.Cogumelo;
import org.junit.jupiter.api.Test;
import pista.CasaDaPista;
import pista.Pista;
import testes.conceito.CorredorConceito;
import testes.conceito.PistaConceito;

import static org.junit.jupiter.api.Assertions.*;

class CorredorConceitoTest {

    @Test
    public void corredorConceitoComecaoCom5DeVidaEAnda3CasasPorVez() {
        Corredor corredorConceito = new CorredorConceito();

        assertEquals(5, corredorConceito.getVida());
        assertEquals(3, corredorConceito.getCasasPorMovimento());
    }

    @Test
    public void temItemEquipadoAposEquipar() {
        Corredor corredorConceito = new CorredorConceito();
        Cogumelo cogumelo = new Cogumelo();

        corredorConceito.equiparItem(cogumelo);

        assertEquals(cogumelo, corredorConceito.getItemEquipado());
    }

    @Test
    public void itemEhDesequipado() {
        Corredor corredorConceito = new CorredorConceito();
        Cogumelo cogumelo = new Cogumelo();

        corredorConceito.equiparItem(cogumelo);

        assertEquals(cogumelo, corredorConceito.getItemEquipado());

        corredorConceito.desequiparItem();

        assertNull(corredorConceito.getItemEquipado());
    }

    @Test
    public void vinculaComPistaAoSerAdicionado() {
        Corredor corredor = new CorredorConceito();
        Pista pista = new PistaConceito(20);

        pista.adicionarCorredor(corredor);

        assertEquals(pista, corredor.getPistaEmQueEstaCorrendo());
    }

    @Test
    public void anda3CasasPorMovimento() throws CorredorNaoEstaNaPistaException {
        Corredor corredor = new CorredorConceito();
        Pista pista = new PistaConceito(20);

        pista.adicionarCorredor(corredor);

        corredor.andar();

        CasaDaPista casaOndeCorredorEsta = pista.getCasaOndeCorredorEsta(corredor);

        assertEquals(3, casaOndeCorredorEsta.getNumeroDaCasa());
    }

    @Test
    public void naoPodeAndarSeEstiverForaDaPista() {
        assertThrows(CorredorNaoEstaNaPistaException.class, () -> {
           Corredor corredor = new CorredorConceito();
           corredor.andar();
        });
    }

    @Test
    public void naoPodeAndarAposTerminarCorrida() {
        assertThrows(CorredorNaoEstaNaPistaException.class, () -> {
            Corredor corredor = new CorredorConceito();
            Pista pista = new PistaConceito(10);

            pista.adicionarCorredor(corredor);

            for (int i = 0; i < 5; i++) {
                corredor.andar();
            }
        });
    }
}