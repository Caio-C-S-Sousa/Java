package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.JogoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VeiculoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController 
{
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;	
	@Autowired
	private JogoService jogoService;
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping(value = "/")
	public String showHome(Model model) 
	{		
		model.addAttribute("qtdVendedor", vendedorService.size());
		model.addAttribute("qtdProduto", produtoService.size());
		model.addAttribute("qtdJogo", jogoService.size());
		model.addAttribute("qtdVeiculo", veiculoService.size());
		
		return "home";	
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterListaVendedor(Model model) 
	{
		var listagem = vendedorService.obterLista();
		
		model.addAttribute("listagem", listagem);
		model.addAttribute("titulo", "Vendedores");
				
		return showHome(model);	
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) 
	{
		var listagem = produtoService.obterLista();
		
		model.addAttribute("listagem", listagem);
		model.addAttribute("titulo", "Produtos");
				
		return showHome(model);	
	}
	
	@GetMapping(value = "/jogo/lista")
	public String obterListaJogo(Model model) 
	{
		var listagem = jogoService.obterLista();
		
		model.addAttribute("listagem", listagem);
		model.addAttribute("titulo", "Jogos");
				
		return showHome(model);	
	}
	
	@GetMapping(value = "/veiculo/lista")
	public String obterListaVeiculo(Model model) 
	{
		var listagem = veiculoService.obterLista();
		
		model.addAttribute("listagem", listagem);
		model.addAttribute("titulo", "Veiculos");
				
		return showHome(model);	
	}	
}