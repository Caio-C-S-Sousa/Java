package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.appvenda.model.domain.Jogo;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Integer>
{

}
