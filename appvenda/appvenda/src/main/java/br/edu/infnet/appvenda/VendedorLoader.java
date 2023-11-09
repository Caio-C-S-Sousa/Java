package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/vendedor.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		System.out.println("Inicia Processamento Vendedor");	
		
		while(linha != null)
		{		
			campos = linha.split(";");
			
			Vendedor v = new Vendedor();
			
			v.setNome(campos[0]);
			v.setCpf(campos[1]);
			v.setEmail(campos[2]);
			v.setEndereco(new Endereco(campos[3]));
			try {
				vendedorService.Include(v);		
			}catch(ConstraintViolationException ex) {
				FileLogger.logException("VENDEDOR: " + v + " - " + ex.getMessage());			
			}
			
			
			linha = leitura.readLine();		
		}
		
		System.out.println("Finaliza Processamento Vendedor");
		
		for(Vendedor vendedor: vendedorService.obterLista()) {
			System.out.println("Vendedor: " + vendedor);	
		}
			
		leitura.close();
	}
}