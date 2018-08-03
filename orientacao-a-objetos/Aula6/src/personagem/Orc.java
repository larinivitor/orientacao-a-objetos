package personagem;

public class Orc extends Personagem {
    private boolean possuiGarra;
    public Orc(String nome, int poderAtaque, boolean possuiGarra){
        super(poderAtaque, nome);
        this.possuiGarra = possuiGarra;
    }

    @Override
    public int calcularPoderAtaque() {
        return possuiGarra ? getPoderAtaque() * 5 : getPoderAtaque();
    }
}
