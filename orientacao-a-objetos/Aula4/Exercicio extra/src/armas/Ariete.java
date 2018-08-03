package armas;

public class Ariete extends Arma {
    private boolean pontaFerro;

    public Ariete(String nome, boolean pontaFerro) {
        super(nome);
        super.tipoAtaque = "terrestre";
        super.poderAtaque = 500;
        this.pontaFerro = pontaFerro;
    }

    public int getPoderAtaque() {
        return pontaFerro ? super.poderAtaque * 2 : super.poderAtaque;
    }

}
