package corredores;

import erros.CorredorNaoEstaNaPistaException;

public class Peach extends Corredor {
    private int vezesQueAndou;

    public Peach() {
        super(6);

        this.vezesQueAndou = 0;
    }


    @Override
    public void andar() throws CorredorNaoEstaNaPistaException {
        this.vezesQueAndou++;

        super.andar();
    }

    @Override
    public int getCasasPorMovimento() {
        return super.getCasasPorMovimento()
                + this.getBonusPorVezesQueAndou();
    }

    private int getBonusPorVezesQueAndou() {
        return this.vezesQueAndou % 3 == 0 ? 2 : 0;
    }
}
