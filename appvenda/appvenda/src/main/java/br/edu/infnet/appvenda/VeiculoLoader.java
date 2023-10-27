package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Veiculo;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VeiculoService;

@Order(2)
@Component
public class VeiculoLoader implements ApplicationRunner {

	@Autowired
	private VeiculoService veiculoService;
	
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
			
			v.setChassi(campos[0]);
			v.setCodigo(Integer.valueOf(campos[1]));
			v.setDescricao(campos[2]);	
			v.setEstoque(Boolean.valueOf(campos[3]));		
			v.setPreco(Float.valueOf(campos[4]));	
			v.setAno(Integer.valueOf(campos[5]));	
			v.setMarca(campos[6]);	
			v.setPortas(Integer.valueOf(campos[7]));	
			v.setModelo(campos[8]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(1);
			
			v.setVendedor(vendedor);
			
			veiculoService.Include(v);
			
			linha = leitura.readLine();		
		}
		
		for(Veiculo v: veiculoService.ObterLista()) {
			System.out.println("Veiculo: " + v);
		}
		
		leitura.close();
	}
}