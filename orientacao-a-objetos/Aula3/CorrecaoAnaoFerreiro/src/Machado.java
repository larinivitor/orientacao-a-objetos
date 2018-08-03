public class Machado {
    private int poder;

    public Machado(int poder) {
        this.poder = poder;
        this.aplicarLimitacaoDePoder();
    }

    public int getPoder() {
        return poder;
    }

    public void receberMelhoria(int melhoria) {
        this.poder += melhoria;

        this.aplicarLimitacaoDePoder();
    }

    private void aplicarLimitacaoDePoder() {
        if (this.poder > 20) {
            this.poder = 20;
        }
    }
}
