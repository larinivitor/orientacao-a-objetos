package pista;

import corredores.Corredor;
import erros.CorredorNaoEstaNaPistaException;

import java.util.LinkedList;
import java.util.List;

public class CasaDaPista {
    private List<Corredor> corredores;
    private int numeroDaCasa;

    public CasaDaPista(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
        this.corredores = new LinkedList<>();
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void adicionarCorredor(Corredor corredor) {
        this.corredores.add(corredor);
    }

    public void removerCorredor(Corredor corredor) {
        this.corredores.remove(corredor);
    }

    public boolean corredorEstaNestaCasa(Corredor corredor) {
        int indice = this.corredores.indexOf(corredor);

        return indice >= 0;
    }

    public List<Corredor> getCorredores() {
        return corredores;
    }
}
