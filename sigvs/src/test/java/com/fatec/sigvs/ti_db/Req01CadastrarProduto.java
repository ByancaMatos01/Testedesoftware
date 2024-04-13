package com.fatec.sigvs.ti_db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvs.model.IProdutoRepository;
import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.servico.IProdutoServico;

@SpringBootTest
class Req01CadastrarProduto {
	@Autowired
	IProdutoServico servico;
	@Autowired
	IProdutoRepository repository;

	@Test
	void Ct01_cadastrar_produto_com_sucesso() {
		Produto produto1 = new Produto("eletrobomba 110v", "maquina de lavar", 22.30, 10);
		Produto produto2 = new Produto("Tirante Original Brastemp E Consul De 7 A 12 Kg 11cm", "lavar louça", 3.90, 20);
		Produto produto3 = new Produto("Termoatuador Lavadora Colormaq Electrolux GE", "maquina de lavar", 29.70, 40);
		repository.saveAll(Arrays.asList(produto1, produto2, produto3));
		assertEquals(3, repository.count());
	}

	@Test
	void ct02_cadastrar_produto_descricao_invalida() {
		Produto produto1 = null;
		try {
			produto1 = new Produto("", "maquina de lavar", 22.30, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertEquals("A descricao não deve estar em branco", e.getMessage());
			assertNull(produto1);
		}
	}

	@Test
	void ct03_cadastrar_produto_custo_invalido() {
		Produto produto1 = null;
		try {
			produto1 = new Produto("eletrobomba 110v", "maquina de lavar", -1, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertEquals("O custo deve ser maior que zero", e.getMessage());
			assertNull(produto1);
		}
	}
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
