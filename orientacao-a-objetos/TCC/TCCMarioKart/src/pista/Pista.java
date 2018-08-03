package pista;

import corredores.Corredor;
import erros.CorredorNaoEstaNaPistaException;
import pista.podium.Podium;

public abstract class Pista {

    private CasaDaPista[] casas;
    private Podium podium;

    public Pista(int numeroDeCasas) {
        this.podium = new Podium();
        this.casas = new CasaDaPista[numeroDeCasas];

        for (int i = 0; i < numeroDeCasas; i++) {
            this.casas[i] = new CasaDaPista(i);
        }
    }

    public void moverCorredor(Corredor corredor, int posicoes) throws CorredorNaoEstaNaPistaException {
        CasaDaPista casaOndeCorredorEsta = this.getCasaOndeCorredorEsta(corredor);

        if (casaOndeCorredorEsta == null) {
            throw new CorredorNaoEstaNaPistaException();
        }

        int novaPosicao = casaOndeCorredorEsta.getNumeroDaCasa() + posicoes;

        casaOndeCorredorEsta.removerCorredor(corredor);

        if (this.terminouACorrida(novaPosicao)) {
            this.promoverAoPodium(corredor);
        }
        else {
            CasaDaPista casaParaOndeVai = this.casas[novaPosicao];
            casaParaOndeVai.adicionarCorredor(corredor);
        }
    }

    public CasaDaPista getCasaOndeCorredorEsta(Corredor corredor) {
        for (CasaDaPista casaDaPista : this.casas) {
            if (casaDaPista.corredorEstaNestaCasa(corredor)) {
                return casaDaPista;
            }
        }

        return null;
    }

    public void adicionarCorredor(Corredor corredor) {
        this.casas[0].adicionarCorredor(corredor);
        corredor.setarPistaEmQueEstaCorrendo(this);
    }

    public void removerCorredor(Corredor corredor) {
        CasaDaPista casaDaPista = this.getCasaOndeCorredorEsta(corredor);
        casaDaPista.removerCorredor(corredor);
    }

    public Podium getPodium() {
        return podium;
    }

    public CasaDaPista[] getCasasDaPista() {
        return this.casas;
    }

    private void promoverAoPodium(Corredor corredor) {
        this.podium.adicionarCorredor(corredor);
    }

    private boolean terminouACorrida(int casaQueCorredorIria) {
        return casaQueCorredorIria >= this.casas.length;
    }


}
