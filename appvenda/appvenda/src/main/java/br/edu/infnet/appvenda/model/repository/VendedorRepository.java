package br.edu.infnet.appvenda.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer>
{
	@Query("from Vendedor v where v.id=:vendedorId")
	public Vendedor obterVendedor(Integer vendedorId);
}