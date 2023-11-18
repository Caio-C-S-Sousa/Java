package br.edu.infnet.vendasApi.model.domain.model.repository;

import org.springframework.stereotype.Repository;
import br.edu.infnet.vendasApi.model.domain.Informacao;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface InformacaoRepository extends CrudRepository<Informacao,Integer> {
	
	
}