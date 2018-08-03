public class Mago {
    private int vida;
    private int poderMagico;
    private int nivel;

    public Mago() {
        this.vida = 10;
        this.poderMagico = 2;
        this.nivel = 1;
    }

    public void passarDeNivel() {
        this.vida += 4;
        this.poderMagico += 2;
        this.nivel += 1;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int novaVida) {
        this.vida = novaVida;
    }
}
