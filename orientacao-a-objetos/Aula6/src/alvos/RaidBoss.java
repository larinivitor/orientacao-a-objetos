package alvos;

public class RaidBoss extends Alvo {
    private int pontosDefesa;
    private String nome;

    public RaidBoss(int pontosVida, String nome, int pontosDefesa) {
        super(pontosVida);
        this.nome = nome;
        this.pontosDefesa = pontosDefesa;
    }

    @Override
    public void receberAtaque(int poderAtaqueRecebido) {
        boolean defesaInteira = pontosDefesa > 0;
        if(defesaInteira)
            pontosDefesa -= poderAtaqueRecebido;
        else
            receberAtaqueDiretoNosPontosVida(poderAtaqueRecebido);
    }

    public int getPontosDefesa() {
        return pontosDefesa;
    }

    private void receberAtaqueDiretoNosPontosVida(int poderAtaqueRecebido){
        this.setPontosVida(getPontosVida() < poderAtaqueRecebido ? 0 : getPontosVida()- poderAtaqueRecebido);
    }
}
