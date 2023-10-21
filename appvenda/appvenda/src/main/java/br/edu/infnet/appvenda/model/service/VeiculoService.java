package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import br.edu.infnet.appvenda.model.domain.Veiculo;

@Service
public class VeiculoService {
	private Map<Integer, Veiculo> mapVeiculo = new HashMap<Integer, Veiculo>();
	
	public void Include(Veiculo v) {
		mapVeiculo.put(v.getCodigo(), v);	
	}
	
	public Collection<Veiculo> ObterLista() {	
		return mapVeiculo.values();
	}	
}
