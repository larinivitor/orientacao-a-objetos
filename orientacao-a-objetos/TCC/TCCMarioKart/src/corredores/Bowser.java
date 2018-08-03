package corredores;

import erros.CorredorNaoEstaNaPistaException;

public class Bowser extends Corredor {
    private int numeroDeVezesQueAndou;

    public Bowser() {
        super(10);

        this.numeroDeVezesQueAndou = 0;
    }

    @Override
    public void andar() throws CorredorNaoEstaNaPistaException {
        this.numeroDeVezesQueAndou++;
        super.andar();
    }

    @Override
    public int getCasasPorMovimento() {
        return super.getCasasPorMovimento()
                + this.getBonusPorVezesQueAndou();
    }

    private int getBonusPorVezesQueAndou() {
        return this.numeroDeVezesQueAndou <= 2 ? -2 : 2;
    }
}
