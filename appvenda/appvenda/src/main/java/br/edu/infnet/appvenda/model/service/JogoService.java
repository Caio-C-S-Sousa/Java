package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Jogo;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.JogoRepository;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class JogoService {
	//private Map<Integer, Jogo> mapVeiculo = new HashMap<Integer, Jogo>();
	
	@Autowired
	private JogoRepository jogoRepository;
	
	public void Include(Jogo j) {
		jogoRepository.save(j);
		//mapVeiculo.put(j.getCodigo(), j);	
	}
	
	public Collection<Jogo> ObterLista() {	
		return (Collection<Jogo>)jogoRepository.findAll();
		//return mapVeiculo.values();
	}	
}