package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Jogo;
import br.edu.infnet.appvenda.model.domain.Vendedor;

@Order(3)
@Component
public class JogoLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("jogo.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null)
		{		
			campos = linha.split(";");
			
			Jogo v = new Jogo();
			
			v.setPlataforma(campos[0]);
			v.setTipo(campos[1]);
			
			System.out.println("Jogo: " + v);
			
			linha = leitura.readLine();		
		}
		
		
		leitura.close();
	}
}