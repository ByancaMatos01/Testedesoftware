package com.fatec.sigvs.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.sigvs.model.IProdutoRepository;
import com.fatec.sigvs.model.Produto;

public class ProdutoServico  implements IProdutoServico{
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	IProdutoRepository produtoRepository;
	@Override
	public List<Produto> consultaCatalogo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> consultaProduto() {
		List<Produto> listaDeProdutos = produtoRepository.findAll();
		return listaDeProdutos;

	}

	@Override
	public List<Produto> consultaPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Produto> cadastrar(Produto produto) {
		logger.info(">>>>>> servico cadastrar produto iniciado ");
		return Optional.ofNullable(produtoRepository.save(produto));

	}

	@Override
	public Optional<Produto> consultarPorId(String id) {
		logger.info(">>>>>> servico consulta por id chamado");
		long codProduto = Long.parseLong(id);
		return produtoRepository.findById(codProduto);

	}

	@Override
	public Optional<Produto> atualizar(Long id, Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(String id) {
		// TODO Auto-generated method stub
		
	}

}
