package br.edu.infnet.appvenda;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Vendedor;

@Component
public class VendedorLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Vendedor v = new Vendedor();
		
		v.setNome("Caio");
		
		System.out.println("Nome: " + v.getNome());
	}
}