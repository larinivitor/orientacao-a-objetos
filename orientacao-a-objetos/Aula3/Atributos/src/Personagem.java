public class Personagem {

    // 1- modificador de acesso
    // 2- tipo do atributo
    // 3- nome do atributo
    private int vida;

    // 1- modificador de acesso
    // 2- mesmo nome da classe
    public Personagem(int vidaInicial) {
        this.vida = vidaInicial;
    }

    public Personagem() {
        this.vida = 10;
    }

    // 1- modificador de acesso
    // 2- tipo de retorno do método
    // 3- nome do método
    public int getVida() {
        return this.vida;
    }
}
