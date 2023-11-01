package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void include(Produto p) {
		produtoRepository.save(p);
	}
	
	public Collection<Produto> obterLista() {	
		return (Collection<Produto>)produtoRepository.findAll();
	}
	
	public Collection<Produto> obterLista(Integer vendedorId) {	
		return (Collection<Produto>)produtoRepository.obterLista(vendedorId) ;
	}
	
	public long size() {	
		return produtoRepository.count();
	}	
}