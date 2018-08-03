package servicos;

import produtos.Produto;
import servicos.contratos.Servico;

public class Manutencao extends Produto implements Servico {
    private int quantidadePessoas;
    private int quantidadeHoras;

    public Manutencao(double valorBase, int percentualLucro, int quantidadePessoas, int quantidadeHoras) {
        super(valorBase, percentualLucro);
        this.quantidadePessoas = quantidadePessoas;
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public double calcularValorBaseServico() {
        return (quantidadePessoas * quantidadeHoras) * super.getValorBase();
    }

    @Override
    public double calcularValorTotalServico() {
        return calcularValorTotal();
    }

    @Override
    public double calcularValorTotal() {
        return calcularValorBaseServico() + calcularValorTotalImpostos() + calcularLucroTotal();
    }

    @Override
    public double calcularLucroTotalServico(){
        return calcularLucroTotal();
    }

    @Override
    public double calcularValorTotalImpostos() {
        return calcularValorBaseServico() * super.getICMS();
    }

    @Override
    public double calcularLucroTotal() {
        return (calcularValorBaseServico() + calcularValorTotalImpostos()) * ((double) super.getPercentualLucro() / 100);
    }
}
