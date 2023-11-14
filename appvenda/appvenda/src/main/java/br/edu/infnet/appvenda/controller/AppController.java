package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.infnet.appvenda.model.service.JogoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VeiculoService;
import br.edu.infnet.appvenda.model.service.VendasService;
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
	@Autowired
	private VendasService vendasService;
	
	
	@GetMapping(value = "/")
	public String showHome(Model model) 
	{			
		model.addAttribute("informacoes", vendasService.obterInformacao());
		model.addAttribute("qtdVendedor", vendedorService.size());
		model.addAttribute("qtdProduto", produtoService.size());
		model.addAttribute("qtdJogo", jogoService.size());
		model.addAttribute("qtdVeiculo", veiculoService.size());
		
		return "home";	
	}
}