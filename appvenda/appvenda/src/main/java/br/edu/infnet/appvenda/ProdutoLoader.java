package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.appvenda.model.domain.Jogo;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Veiculo;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(1)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/produtos.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		System.out.println("Inicia Processamento Produtos");	
		
		while(linha != null)
		{		
			campos = linha.split(";");
				
			if(campos[0] == "J") {
				AddJogo(campos);	
			}else if(campos[0] == "V") {
				AddVeiculo(campos);
			}

			linha = leitura.readLine();		
		}
		
		System.out.println("Finaliza Processamento Produtos");
		
		for(Produto p: produtoService.ObterLista()) {
			System.out.println("Produto: " + p);	
		}
			
		leitura.close();
	}
	
	
	private void AddJogo(String[] campos) {	
		Jogo jogo = new Jogo();
		
		jogo.setCodigo(Integer.valueOf(campos[1]));
		jogo.setDescricao(campos[2]);	
		jogo.setEstoque(Boolean.valueOf(campos[3]));		
		jogo.setPreco(Float.valueOf(campos[4]));
		jogo.setPlataforma(campos[5]);
		jogo.setTipo(campos[6]);
		
		produtoService.Include(jogo);
	}
	
	private void AddVeiculo(String[] campos) {	
		Veiculo v = new Veiculo();
		
		v.setCodigo(Integer.valueOf(campos[1]));
		v.setDescricao(campos[2]);	
		v.setEstoque(Boolean.valueOf(campos[3]));		
		v.setPreco(Float.valueOf(campos[4]));	
		v.setAno(Integer.valueOf(campos[5]));	
		v.setMarca(campos[6]);	
		v.setPortas(Integer.valueOf(campos[7]));	
		v.setModelo(campos[8]);
		
		produtoService.Include(v);
	}
}