package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Vendedor;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/vendedor.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null)
		{		
			campos = linha.split(";");
			
			Vendedor v = new Vendedor();
			
			v.setNome(campos[0]);
			v.setCpf(campos[1]);
			v.setEmail(campos[2]);
			
			System.out.println("Vendedor: " + v);
			
			linha = leitura.readLine();		
		}
		
		
		leitura.close();
	}
}