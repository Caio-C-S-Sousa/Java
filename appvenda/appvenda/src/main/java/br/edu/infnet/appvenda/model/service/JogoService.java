package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Jogo;

@Service
public class JogoService {
	private Map<Integer, Jogo> mapVeiculo = new HashMap<Integer, Jogo>();
	
	public void Include(Jogo j) {
		mapVeiculo.put(j.getCodigo(), j);	
	}
	
	public Collection<Jogo> ObterLista() {	
		return mapVeiculo.values();
	}	
}