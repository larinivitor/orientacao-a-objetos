package corredores;

public class Mario extends Corredor {
    public Mario() {
        super(7);
    }

    @Override
    public int getCasasPorMovimento() {
        return super.getCasasPorMovimento() + 1;
    }
}
