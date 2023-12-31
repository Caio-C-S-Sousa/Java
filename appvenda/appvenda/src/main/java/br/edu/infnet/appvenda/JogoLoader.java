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
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.JogoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(4)
@Component
public class JogoLoader implements ApplicationRunner {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;
	
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
			
			jogoService.include(jogo);
					
			linha = leitura.readLine();		
		}
		leitura.close();
		
		for(Jogo jogo: jogoService.obterLista()) {
			System.out.println("Jogo: " + jogo);	
		}
			
		var listProduto = produtoService.obterLista();
		
		System.out.println("Produto Count: " + listProduto.size());	
		
		for(Produto produto: listProduto) {
			System.out.println("Produto: " + produto);	
								
			System.out.println("Vendedor do produto: " + vendedorService.obter(produto.getVendedor().getId()));	
		}	
	}
}