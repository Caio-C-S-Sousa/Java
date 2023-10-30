package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	//private Map<String,Vendedor> mapaVendedor = new HashMap<String, Vendedor>();
	
	public void Include(Vendedor v) {
		vendedorRepository.save(v);
		//mapaVendedor.put(v.getCpf(), v);	
	}
	
	public Collection<Vendedor> ObterLista() {		
		 return (Collection<Vendedor>)vendedorRepository.findAll();
		//return mapaVendedor.values();
	}	
	
	public Vendedor obter(Integer vendedorId) {	
		return vendedorRepository.ObterVendedor(vendedorId);
		//return mapaProduto.values();
	}	
}