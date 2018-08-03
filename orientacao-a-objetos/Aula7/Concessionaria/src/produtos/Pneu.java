package produtos;

public class Pneu extends Produto {
    public Pneu(double valorBase, int percentualLucro){
        super(valorBase, percentualLucro);
    }

    @Override
    public double calcularValorTotal() {
        return getValorBase() + calcularLucroTotal();
    }

    @Override
    public double getValorBase(){
        return super.getValorBase() + calcularValorTotalImpostos();
    }
}
