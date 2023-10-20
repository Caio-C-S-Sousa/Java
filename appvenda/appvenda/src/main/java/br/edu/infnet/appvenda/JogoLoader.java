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
		
		FileReader fileReader = new FileReader("files/jogo.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null)
		{		
			campos = linha.split(";");
			
			Jogo jogo = new Jogo();
			
			jogo.setCodigo(Integer.valueOf(campos[0]));
			jogo.setDescricao(campos[1]);	
			jogo.setEstoque(Boolean.valueOf(campos[2]));		
			jogo.setPreco(Float.valueOf(campos[3]));
			jogo.setPlataforma(campos[4]);
			jogo.setTipo(campos[5]);
			
			System.out.println("Jogo: " + jogo);
			
			linha = leitura.readLine();		
		}
		
		
		leitura.close();
	}
}