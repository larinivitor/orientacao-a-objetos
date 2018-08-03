package dias;

import produtos.Produto;
import servicos.contratos.Servico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dia {
    private List<Produto> produtosVendidos;
    private List<Servico> servicosRealizados;

    public Dia(){
        produtosVendidos = new ArrayList<>();
        servicosRealizados = new ArrayList<>();
    }

    public void realizarVendaProduto(Produto produto){
        produtosVendidos.add(produto);
    }
    public void prestarServico(Servico servico){
        servicosRealizados.add(servico);
    }
    public void realizarVendaProdutosEmLote(List<Produto> produtos){
        produtosVendidos.addAll(produtos);
    }

    public double consultarTotalEntradaDia(){
        return consultarEntradaProdutos() + consultarEntradaServicos();
    }

    public double consultarLucroTotalDia(){
        return consultarLucroProdutos() + consultarLucroServicos();
    }

    public double consultarEntradaServicos(){
        return servicosRealizados.stream().mapToDouble(Servico::calcularValorTotalServico).sum();
    }
    public double consultarEntradaProdutos(){
        return produtosVendidos.stream().mapToDouble(Produto::calcularValorTotal).sum();
    }

    public double consultarLucroProdutos(){
        return produtosVendidos.stream().mapToDouble(Produto::calcularLucroTotal).sum();
    }
    public double consultarLucroServicos(){
        return servicosRealizados.stream().mapToDouble(Servico::calcularLucroTotalServico).sum();
    }

    public List<Produto> consultarOrdenandoMaisBaratoAteMaisCaro(){
        Comparator<Produto> porValorTotal = Comparator.comparing(Produto::calcularValorTotal);
        return produtosVendidos.stream().sorted(porValorTotal).collect(Collectors.toList());
    }

    public List<Produto> consultarOrdenandoMaisCaroAteMaisBarato(){
        Comparator<Produto> porValorTotal = Comparator.comparing(Produto::calcularValorTotal).reversed();
        return produtosVendidos.stream().sorted(porValorTotal).collect(Collectors.toList());
    }

    public void removerProdutoLista(Produto produto){
        produtosVendidos.remove(produto);
    }
    public void removerServicoLista(Servico servico){
        servicosRealizados.remove(servico);
    }

    public List<Produto> getProdutosVendidos(){
        return produtosVendidos;
    }

    public List<Servico> getServicosRealizados(){
        return servicosRealizados;
    }


}
