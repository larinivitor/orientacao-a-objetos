package personagem;

public class Humano extends Personagem {
    private boolean possuiArco;

    public Humano(String nome, int poderAtaque, boolean possuiArco){
        super(poderAtaque, nome);
        this.possuiArco = possuiArco;
    }

    @Override
    public int calcularPoderAtaque() {
        return possuiArco ? getPoderAtaque() * 3 : getPoderAtaque();
    }
}
