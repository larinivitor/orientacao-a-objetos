package personagem;

public class Elfo extends Personagem {
    private int poderMagico;

    public Elfo(String nome, int poderAtaque, int poderMagico){
        super(poderAtaque, nome);
        this.poderMagico = poderMagico;
    }

    @Override
    public int calcularPoderAtaque() {
        return poderMagico + getPoderAtaque();
    }
}
