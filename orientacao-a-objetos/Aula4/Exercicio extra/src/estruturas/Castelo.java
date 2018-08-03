package estruturas;

import armas.*;

public class Castelo {
    private String nome;
    private int pontosDefesa;
    private Muro muro;
    private boolean destruido;

    public Castelo(String nome) {
        this.muro = new Muro();
        this.pontosDefesa = 50000;
        this.nome = nome;
        this.destruido = false;
    }

    public int getPontosDefesa(){
        return pontosDefesa;
    }

    public void receberAtaque(Arma arma) {
        if (!destruido) {
            if (arma.getTipoAtaque().equals("aereo")) {
                receberAtaqueAereo(arma.getPoderAtaque());
            } else {
                receberAtaqueTerrestre(arma.getPoderAtaque());
            }
            verificarDestruido();
        }
    }

    public boolean getDestruido(){
        return this.destruido;
    }

    private void receberAtaqueAereo(int poderAtaque) {
        pontosDefesa = pontosDefesa - poderAtaque;
    }

    private void receberAtaqueTerrestre(int poderAtaque) {
        if (muro.getDefesa() > 0) {
            muro.receberAtaque(poderAtaque);
        } else {
            pontosDefesa = pontosDefesa - poderAtaque;
        }
    }

    private void verificarDestruido() {
        if (pontosDefesa > 0) {
            destruido = false;
        } else {
            destruido = true;
        }
    }
}
