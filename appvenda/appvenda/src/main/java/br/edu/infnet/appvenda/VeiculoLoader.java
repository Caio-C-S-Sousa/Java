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
		
		FileReader fileReader = new FileReader("files/veiculo.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null)
		{		
			campos = linha.split(";");
			
			Veiculo v = new Veiculo();
			
			v.setCodigo(Integer.valueOf(campos[0]));
			v.setDescricao(campos[1]);	
			v.setEstoque(Boolean.valueOf(campos[2]));		
			v.setPreco(Float.valueOf(campos[3]));	
			v.setAno(Integer.valueOf(campos[4]));	
			v.setMarca(campos[5]);	
			v.setPortas(Integer.valueOf(campos[6]));
			
			v.setModelo(campos[7]);
			
			System.out.println("Veiculo: " + v);
			
			linha = leitura.readLine();		
		}
		
		
		leitura.close();
	}
}