package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.appvenda.model.domain.Veiculo;
import br.edu.infnet.appvenda.model.service.VeiculoService;

@Controller
public class VeiculoController {
	@Autowired
	private AppController appController;
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping(value = "/veiculo/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		veiculoService.excluir(id);

		return "redirect:/veiculo/lista";
	}

	@GetMapping(value = "/veiculo/lista")
	public String obterLista(Model model) {
		var listagem = veiculoService.obterLista();

		model.addAttribute("rota", "veiculo");
		model.addAttribute("listagem", listagem);
		model.addAttribute("titulo", "Veiculos");

		return appController.showHome(model);
	}
	
	@GetMapping(value = "/veiculo/pesquisar")
	public String pesquisar(Model model, String campoBusca) 
	{
		Veiculo veiculo = veiculoService.pesquisar(campoBusca);
		
		if (veiculo != null) {
			model.addAttribute("objeto", veiculo);
			return appController.showHome(model);
		}
		
		return "redirect:/veiculo/lista";
	}
}
