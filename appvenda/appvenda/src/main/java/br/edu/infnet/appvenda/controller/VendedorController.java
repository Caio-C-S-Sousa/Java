package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class VendedorController {

	@Autowired
	private AppController appController;
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(value = "/vendedor/{id}/excluir")
	public String excluir(Integer id) {
		 vendedorService.excluir(id);	
		 
		 return null;
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterLista(Model model) 
	{
		var listagem = vendedorService.obterLista();
		
		model.addAttribute("listagem", listagem);
		model.addAttribute("titulo", "Vendedores");
				
		return appController.showHome(model);	
	}
}