package com.fatec.sigvs.ti_db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvs.model.IProdutoRepository;
import com.fatec.sigvs.model.Produto;
@SpringBootTest
class Req01CadastrarProduto {
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

}