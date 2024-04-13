package com.fatec.sigvs.ti_db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvs.model.IProdutoRepository;
import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.servico.IProdutoServico;

@SpringBootTest
public class Req02ConsultarProduto {
    
    @Autowired
    IProdutoServico servico;
    
    @Autowired
    IProdutoRepository repository;
    
    @Test
    void ct01CadastrarProdutoComSucesso() {
    //dado que nao existem produtos cadastrados
    repository.deleteAll();
    Produto produto1 = new Produto("eletrobomba 110v", "maquina de lavar", 22.30, 10);
    //quando cadastro um produto
    servico.cadastrar(produto1);
    //entao retorna 1
    assertEquals(1, repository.count());
    }
    @Test
    void ct02ConsultarProduto() {
    repository.deleteAll();
    Produto produto1 = new Produto("eletrobomba 110v", "maquina de lavar", 22.30, 10);
    Produto produto2 = new Produto("Tirante Original Brastemp E Consul De 7 A 12 Kg 11cm", "lavar louça", 3.90, 20);
    Produto produto3 = new Produto("Termoatuador Lavadora Colormaq Electrolux GE", "maquina de lavar", 29.70, 40);
    repository.saveAll(Arrays.asList(produto1, produto2, produto3));
    List<Produto> lista = servico.consultaProduto();
    assertEquals(3, lista.size());
    }


}