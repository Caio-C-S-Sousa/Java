package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Veiculo;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.JogoRepository;
import br.edu.infnet.appvenda.model.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public void include(Veiculo v) {
		veiculoRepository.save(v);
	}
	
	public Collection<Veiculo> obterLista() {	
		return (Collection<Veiculo>)veiculoRepository.findAll();		
	}	
	
	public long size() {	
		return veiculoRepository.count();
	}	
}
