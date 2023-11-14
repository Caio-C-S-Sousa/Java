package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.edu.infnet.appvenda.clients.IEnderecoClient;
import br.edu.infnet.appvenda.clients.IVendasClient;
import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public void Include(Vendedor v) {
		
		Endereco endereco = enderecoClient.buscarCep(v.getEndereco().getCep());
		
		v.setEndereco(endereco);
		
		vendedorRepository.save(v);
	}
	
	public Collection<Vendedor> obterLista() {		
		 return (Collection<Vendedor>)vendedorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}	
	
	public Vendedor obter(Integer vendedorId) {	
		return vendedorRepository.obterVendedor(vendedorId);
	}	
	
	public long size() {	
		return vendedorRepository.count();
	}	
	
	public void excluir(Integer id) {		
		vendedorRepository.deleteById(id);
	}	
	
	public Vendedor pesquisar(String cpf) {	
		return vendedorRepository.findByCpf(cpf);
	}	
}