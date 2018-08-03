public class AnaoFerreiro {
    private int idade;
    private int nivelHabilidade;

    public AnaoFerreiro(int idade, int nivelHabilidade) {
        this.idade = idade;
        this.nivelHabilidade = nivelHabilidade;
    }


    public Machado forjarMachado() {
        int poderDoMachado = this.nivelHabilidade;

        poderDoMachado += this.getPoderDeCriacaoDeMachadoPelaIdade();

        return new Machado(poderDoMachado);
    }

    private int getPoderDeCriacaoDeMachadoPelaIdade() {
        if (this.idade >= 100 && this.idade <= 200) {
            return 2;
        }

        return 0;
    }

    public boolean podeMelhorarMachado() {
        return this.idade > 150
                && this.nivelHabilidade > 5;
    }

    public void melhorarMachado(Machado machado) {
        if (!this.podeMelhorarMachado()) {
            return;
        }

        int melhoria = this.getBonusDeMelhoriaParaMachado();

        machado.receberMelhoria(melhoria);
    }

    public int getBonusDeMelhoriaParaMachado() {
        if (!this.podeMelhorarMachado()) {
            return 0;
        }

        if (this.nivelHabilidade <= 10) {
            return 2;
        }
        else {
            return 3;
        }
    }
}






















