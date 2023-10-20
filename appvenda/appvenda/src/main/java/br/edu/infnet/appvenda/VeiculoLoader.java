package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Veiculo;
import br.edu.infnet.appvenda.model.domain.Vendedor;

@Order(2)
@Component
public class VeiculoLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("veiculo.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null)
		{		
			campos = linha.split(";");
			
			Veiculo v = new Veiculo();
			
			v.setAno(Integer.parseInt(campos[0]));
			
			v.setMarca(campos[1]);
			
			v.setPortas(Integer.parseInt(campos[2]));
			
			v.setModelo(campos[3]);
			
			System.out.println("Veiculo: " + v);
			
			linha = leitura.readLine();		
		}
		
		
		leitura.close();
	}
}