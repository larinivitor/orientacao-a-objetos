package tests;

import dias.Dia;
import org.junit.jupiter.api.Test;
import produtos.Pneu;
import produtos.Produto;
import servicos.Revisao;
import servicos.contratos.Servico;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaTest {
    @Test
    public void testarRemoverProdutoListaProdutosVendidos(){
        //Arrange
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(100, 10);
        Produto pneu3 = new Pneu(100, 10);
        Produto pneu4 = new Pneu(100, 10);
        List<Produto> pneusEsperados = new ArrayList<>();
        pneusEsperados.add(pneu1);
        pneusEsperados.add(pneu2);
        pneusEsperados.add(pneu3);
        Dia dia = new Dia();
        //Act
        dia.realizarVendaProduto(pneu1);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu4);
        dia.removerProdutoLista(pneu4);
        //Assert
        assertEquals(pneusEsperados, dia.getProdutosVendidos());
    }
    @Test
    public void testarRemoverServicoListaServicosRealizados(){
        //Arrange
        List<Servico> servicosEsperados = new ArrayList<>();
        Servico servico1 = new Revisao(100, 100);
        Servico servico2 = new Revisao(100, 100);
        Servico servico3 = new Revisao(100, 100);
        Servico servico4 = new Revisao(100, 100);
        servicosEsperados.add(servico1);
        servicosEsperados.add(servico2);
        Dia dia = new Dia();
        //Act
        dia.prestarServico(servico1);
        dia.prestarServico(servico2);
        dia.prestarServico(servico3);
        dia.prestarServico(servico4);
        dia.removerServicoLista(servico4);
        dia.removerServicoLista(servico3);
        //Assert
        assertEquals(servicosEsperados, dia.getServicosRealizados());
    }
    @Test
    public void testarOrdernarProdutoDoMaisBaratoAteMaisCaro(){
        //Arrange
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(200, 10);
        Produto pneu3 = new Pneu(300, 10);
        Produto pneu4 = new Pneu(400, 10);
        List<Produto> pneusEsperados = new ArrayList<>();
        pneusEsperados.add(pneu1);
        pneusEsperados.add(pneu2);
        pneusEsperados.add(pneu3);
        pneusEsperados.add(pneu4);
        Dia dia = new Dia();
        //Act
        dia.realizarVendaProduto(pneu4);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu1);
        //Assert
        assertEquals(pneusEsperados, dia.consultarOrdenandoMaisBaratoAteMaisCaro());
    }
    @Test
    public void testarOrdernarProdutoDoMaisCaroAteMaisBarato(){
        //Arrange
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(200, 10);
        Produto pneu3 = new Pneu(300, 10);
        Produto pneu4 = new Pneu(400, 10);
        List<Produto> pneusEsperados = new ArrayList<>();
        pneusEsperados.add(pneu4);
        pneusEsperados.add(pneu3);
        pneusEsperados.add(pneu2);
        pneusEsperados.add(pneu1);
        Dia dia = new Dia();
        //Act
        dia.realizarVendaProduto(pneu4);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu1);
        //Assert
        assertEquals(pneusEsperados, dia.consultarOrdenandoMaisCaroAteMaisBarato());
    }
    @Test
    public void testarEntradaProduto(){
        //Arrange
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(100, 10);
        Produto pneu3 = new Pneu(100, 10);
        Produto pneu4 = new Pneu(100, 10);
        double valorEsperado = 497.2;
        Dia dia = new Dia();
        //Act
        dia.realizarVendaProduto(pneu4);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu1);
        //Assert
        assertEquals(valorEsperado, dia.consultarEntradaProdutos());
    }

    @Test
    public void testarEntradaServicos(){
        Servico servico1 = new Revisao(100, 100);
        Servico servico2 = new Revisao(100, 100);
        Servico servico3 = new Revisao(100, 100);
        Servico servico4 = new Revisao(100, 100);
        Dia dia = new Dia();
        double valorEsperado = 800.0;
        //Act
        dia.prestarServico(servico1);
        dia.prestarServico(servico2);
        dia.prestarServico(servico3);
        dia.prestarServico(servico4);
        //Assert
        assertEquals(valorEsperado, dia.consultarEntradaServicos());
    }
    @Test
    public void testarEntradaTotal(){
        Servico servico1 = new Revisao(100, 100);
        Servico servico2 = new Revisao(100, 100);
        Servico servico3 = new Revisao(100, 100);
        Servico servico4 = new Revisao(100, 100);
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(100, 10);
        Produto pneu3 = new Pneu(100, 10);
        Produto pneu4 = new Pneu(100, 10);
        Dia dia = new Dia();
        double valorEsperado = 1297.2;
        //Act
        dia.prestarServico(servico1);
        dia.prestarServico(servico2);
        dia.prestarServico(servico3);
        dia.prestarServico(servico4);
        dia.realizarVendaProduto(pneu4);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu1);
        //Assert
        assertEquals(valorEsperado, dia.consultarTotalEntradaDia());
    }
    @Test
    public void testarEntradaLucroServico(){
        Servico servico1 = new Revisao(100, 100);
        Servico servico2 = new Revisao(100, 100);
        Servico servico3 = new Revisao(100, 100);
        Servico servico4 = new Revisao(100, 100);
        Dia dia = new Dia();
        double valorEsperado = 400.0;
        //Act
        dia.prestarServico(servico1);
        dia.prestarServico(servico2);
        dia.prestarServico(servico3);
        dia.prestarServico(servico4);
        //Assert
        assertEquals(valorEsperado, dia.consultarLucroServicos());
    }
    @Test
    public void testarEntradaLucroProduto(){
        //Arrange
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(100, 10);
        Produto pneu3 = new Pneu(100, 10);
        Produto pneu4 = new Pneu(100, 10);
        double valorEsperado = 45.2;
        Dia dia = new Dia();
        //Act
        dia.realizarVendaProduto(pneu4);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu1);
        //Assert
        assertEquals(valorEsperado, dia.consultarLucroProdutos());
    }
    @Test
    public void testarEntradaLucroDia(){
        //Arrange
        Produto pneu1 = new Pneu(100, 10);
        Produto pneu2 = new Pneu(100, 10);
        Produto pneu3 = new Pneu(100, 10);
        Produto pneu4 = new Pneu(100, 10);
        Servico servico1 = new Revisao(100, 100);
        Servico servico2 = new Revisao(100, 100);
        Servico servico3 = new Revisao(100, 100);
        Servico servico4 = new Revisao(100, 100);
        double valorEsperado = 445.2;
        Dia dia = new Dia();
        //Act
        dia.realizarVendaProduto(pneu4);
        dia.realizarVendaProduto(pneu2);
        dia.realizarVendaProduto(pneu3);
        dia.realizarVendaProduto(pneu1);
        dia.prestarServico(servico1);
        dia.prestarServico(servico2);
        dia.prestarServico(servico3);
        dia.prestarServico(servico4);
        //Assert
        assertEquals(valorEsperado, dia.consultarLucroTotalDia());
    }

}
