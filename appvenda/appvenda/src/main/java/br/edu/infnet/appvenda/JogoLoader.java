package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.appvenda.model.domain.Jogo;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.JogoService;

@Order(3)
@Component
public class JogoLoader implements ApplicationRunner {

	@Autowired
	private JogoService jogoService;
	
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
			jogo.setNome(campos[4]);
			jogo.setPlataforma(campos[5]);
			jogo.setTipo(campos[6]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(1);
			
			jogo.setVendedor(vendedor);
			
			jogoService.Include(jogo);
					
			linha = leitura.readLine();		
		}
		
		for(Jogo jogo: jogoService.ObterLista()) {
			System.out.println("Jogo: " + jogo);	
		}
		
		leitura.close();
	}
}