package servicos;

import produtos.Pneu;
import servicos.contratos.Servico;

import java.util.List;

public class TrocaPneu implements Servico {
    private static final double VALOR_BASE = 50.50;
    private static final double VALOR_BASE_LUCRO = 50.25;
    private List<Pneu> pneus;

    public  TrocaPneu(List<Pneu> pneus){
        this.pneus = pneus;
    }

    @Override
    public double calcularValorBaseServico() {
        return pneus.size() * (VALOR_BASE + pneus.stream().mapToDouble(Pneu::getValorBase).sum());
    }

    @Override
    public double calcularValorTotalServico() {
        return pneus.size() * (VALOR_BASE + VALOR_BASE_LUCRO) + pneus.stream().mapToDouble(Pneu::calcularValorTotal).sum();
    }

    @Override
    public double calcularLucroTotalServico() {
        return pneus.size() * VALOR_BASE_LUCRO;
    }
}
