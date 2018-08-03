package armas;

public class Catapulta extends Arma {
    private int alturaAtaque;

    public Catapulta(String nome, int alturaAtaque) {
        super(nome);
        super.poderAtaque = 3500;
        super.tipoAtaque = "aereo";
        this.alturaAtaque = alturaAtaque;
    }

    @Override
    public int getPoderAtaque() {
        return (poderAtaque + (alturaAtaque * 2));
    }
}
