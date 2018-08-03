package pista.rainbowroad;

import corredores.Corredor;
import erros.CorredorNaoEstaNaPistaException;
import pista.CasaDaPista;

public class CasaComTurbo extends CasaDaPista {

    public CasaComTurbo(int numeroDaCasa) {
        super(numeroDaCasa);
    }

    @Override
    public void adicionarCorredor(Corredor corredor) {
        super.adicionarCorredor(corredor);

        try {
            corredor.andar();
        }
        catch (CorredorNaoEstaNaPistaException ex) {
            // o corredor não pode cair em uma casa
            // que não está em uma pista.
            // neste caso, não há problemas em silenciar o erro.
            // devemos tratar os erros em cenários onde realmente
            // poderemos chamar o método em um cenário existente,
            // porém inválido.
        }

    }
}
