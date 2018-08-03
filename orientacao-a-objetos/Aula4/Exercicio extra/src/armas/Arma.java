package armas;

public class Arma {
    protected String nome;
    protected int poderAtaque;
    protected String tipoAtaque;

    public Arma(String nome) {
        this.nome = nome;
        this.poderAtaque = 20;
        this.tipoAtaque = "normal";
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public String getTipoAtaque() {
        return this.tipoAtaque;
    }
}
