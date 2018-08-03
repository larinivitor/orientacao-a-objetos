public class Arma {
    private int municao;

    public Arma() {
        this.municao = 6;
    }

    public void atirar() throws ArmaSemMunicaoException {
//        if (this.municao > 0) {
//            this.municao -= 1;
//            return;
//        }
//        else {
//            this.recarregar();
//            this.atirar();
//        }

        if (this.municao > 0) {
            this.municao -= 1;
            return;
        }

        throw new ArmaSemMunicaoException("Ooops, sem balas.");
    }

    public void recarregar() throws SemMunicaoExtraException {
        this.municao += this.getMunicaoExtra();

        if (this.municao < 1) {
            throw new SemMunicaoExtraException();
        }
    }

    private int getMunicaoExtra() {
        // fingir que é caixinha de bala
        return 0;
    }
}









