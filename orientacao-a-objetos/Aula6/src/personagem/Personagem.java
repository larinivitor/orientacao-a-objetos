package personagem;

public class Personagem {
    private int poderAtaque;
    private String nome;

    public Personagem(int poderAtaque, String nome){
        this.poderAtaque = poderAtaque;
        this.nome = nome;
    }

    protected int getPoderAtaque(){
        return poderAtaque;
    }

    public int calcularPoderAtaque(){
        return poderAtaque;
    }

    public String getNome() {
        return nome;
    }
}
