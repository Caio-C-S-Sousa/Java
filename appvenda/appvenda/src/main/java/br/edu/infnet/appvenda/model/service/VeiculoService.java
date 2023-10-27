package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appvenda.model.domain.Veiculo;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.JogoRepository;
import br.edu.infnet.appvenda.model.repository.VeiculoRepository;

@Service
public class VeiculoService {
	//private Map<Integer, Veiculo> mapVeiculo = new HashMap<Integer, Veiculo>();
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public void Include(Veiculo v) {
		veiculoRepository.save(v);
		//mapVeiculo.put(v.getCodigo(), v);	
	}
	
	public Collection<Veiculo> ObterLista() {	
		return (Collection<Veiculo>)veiculoRepository.findAll();		
		//return mapVeiculo.values();
	}	
}
