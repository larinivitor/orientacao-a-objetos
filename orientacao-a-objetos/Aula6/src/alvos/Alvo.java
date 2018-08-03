package alvos;

public class Alvo {
    private int pontosVida;
    private boolean destruido;

    public Alvo(int pontoVida){
        this.pontosVida = pontoVida;
    }

    protected void setPontosVida(int pontosVida){
        this.pontosVida = pontosVida;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void receberAtaque(int poderAtaqueRecebido){
        pontosVida -= poderAtaqueRecebido;
        //mais elegante
        destruido = pontosVida <= 0;
    }
}
