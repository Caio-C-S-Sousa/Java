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
	
	public void Include(Vendedor v) {
		vendedorRepository.save(v);
	}
	
	public Collection<Vendedor> obterLista() {		
		 return (Collection<Vendedor>)vendedorRepository.findAll();
	}	
	
	public Vendedor obter(Integer vendedorId) {	
		return vendedorRepository.obterVendedor(vendedorId);
	}	
	
	public long size() {	
		return vendedorRepository.count();
	}	
}