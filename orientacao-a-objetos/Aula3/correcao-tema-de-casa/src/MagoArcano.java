public class MagoArcano {
    private int vida;
    private int mana;
    private int nivel;
    private int poderMagico;

    private int quantidadeDeVezesQueTreinouNaAcademiaArcana;

    private boolean treinouNaAcademiaDoFogo;
    private int poderDaAcademiaDoFogoAdquirido;

    public MagoArcano() {
        this.vida = 10;
        this.mana = 4;
        this.nivel = 1;
        this.poderMagico = 2;
    }

    public void subirDeNivel() {
        int multiplicador = 2;
        this.vida *= multiplicador;
        this.mana *= multiplicador;
        this.poderMagico *= multiplicador;

        this.nivel += 1;
    }


    public int getVida() {
        return this.vida;
    }

    public int getMana() {
        return this.mana;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getPoderMagico() {
        return this.poderMagico + this.getPoderMagicoBonusDaAcademiaArcana();
    }

    public void treinarNaAcademiaArcana(AcademiaArcana academiaArcana) {
        academiaArcana.aplicarTreinamento(this);

        this.quantidadeDeVezesQueTreinouNaAcademiaArcana += 1;
    }

    public void treinarNaAcademiaDoFogo(AcademiaDoFogo academiaDoFogo) {
        this.treinouNaAcademiaDoFogo = true;
        this.poderDaAcademiaDoFogoAdquirido = academiaDoFogo.getPoder();
    }

    public BolaDeFogo lancarBolaDeFogo(int manaUtilizada) {
        if (!this.treinouNaAcademiaDoFogo) {
            return null;
        }

        if (manaUtilizada > this.mana) {
            manaUtilizada = this.mana;
        }

        this.mana -= manaUtilizada;

        BolaDeFogo bolaDeFogo = new BolaDeFogo(
                this.poderDaAcademiaDoFogoAdquirido,
                this.getPoderMagico(),
                manaUtilizada);

        return bolaDeFogo;
    }

    private int getPoderMagicoBonusDaAcademiaArcana() {
        return this.quantidadeDeVezesQueTreinouNaAcademiaArcana >= 3 ? 5 : 0;
    }
}




