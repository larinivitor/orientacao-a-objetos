package servicos;

import servicos.contratos.Servico;

public class Revisao implements Servico {
    private double valorFixoRevisao;
    private double valorFixoLucro;

    public Revisao(double valorFixoRevisao, double valorFixoLucro){
        this.valorFixoLucro = valorFixoLucro;
        this.valorFixoRevisao = valorFixoRevisao;
    }

    @Override
    public double calcularValorBaseServico() {
        return valorFixoRevisao;
    }

    @Override
    public double calcularValorTotalServico() {
        return  valorFixoRevisao + valorFixoLucro;
    }
    @Override
    public double calcularLucroTotalServico(){
        return valorFixoLucro;
    }
}
