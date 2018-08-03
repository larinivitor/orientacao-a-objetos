package estruturas;

public class Muro {
    private int defesa;

    public Muro() {
        this.defesa = 10000;
    }

    public int getDefesa() {
        return defesa;
    }

    public void receberAtaque(int poderAtaque) {
        defesa = defesa - poderAtaque;
    }
}
