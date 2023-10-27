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
	//private Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>();
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void Include(Produto p) {
		produtoRepository.save(p);
		//mapaProduto.put(p.getCodigo(), p);	
	}
	
	public Collection<Produto> ObterLista() {	
		return (Collection<Produto>)produtoRepository.findAll();
		//return mapaProduto.values();
	}
	
	public Collection<Produto> ObterLista(Integer vendedorId) {	
		return (Collection<Produto>)produtoRepository.obterLista(vendedorId) ;
		//return mapaProduto.values();
	}	
}