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
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/produtos.txt");
		BufferedReader leitura = new BufferedReader(fileReader);	
		String linha = leitura.readLine();
		
		String[] campos = null;
		
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
		
		leitura.close();

		var listProduto = produtoService.obterLista();
		
		System.out.println("Produto Count: " + listProduto.size());	
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("Produto: " + produto);			
		}
		
		
		/*for(Vendedor vendedor: vendedorService.ObterLista()) {				
			//Integer vendedorId = vendedor.getId();
			
			//System.out.println("Vendedor ID: " + vendedorId);	
			
			for(Produto p: produtoService.obterLista(1)) 
			{
				System.out.println("Produto2: " + p);	
			}
		}*/
	}
	
	
	private void AddJogo(String[] campos) {	
		Jogo jogo = new Jogo();
		
		jogo.setCodigo(Integer.valueOf(campos[1]));
		jogo.setDescricao(campos[2]);	
		jogo.setEstoque(Boolean.valueOf(campos[3]));		
		jogo.setPreco(Float.valueOf(campos[4]));
		jogo.setPlataforma(campos[5]);
		jogo.setTipo(campos[6]);
		
		//Vendedor vendedor = new Vendedor();
		//vendedor = vendedorService.obter(1);
		
		//jogo.setVendedor(vendedor);
		
		produtoService.include(jogo);
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
		
		//Vendedor vendedor = new Vendedor();
		//vendedor = vendedorService.obter(1);
		
		//v.setVendedor(vendedor);
		
		produtoService.include(v);
	}
}