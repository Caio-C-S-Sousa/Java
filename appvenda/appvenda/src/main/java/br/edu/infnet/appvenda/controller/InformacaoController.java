package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.infnet.appvenda.model.domain.Informacao;
import br.edu.infnet.appvenda.model.service.InformacaoService;

@Controller
public class InformacaoController {

	@Autowired
	private InformacaoService informacaoService;
	
	@PostMapping(value = "/informacao/incluir")
	public String incluir(Informacao informacao) {
				
		informacaoService.incluir(informacao);
			
		return "redirect:/";
	}
	
	/*@GetMapping(value = "/informacao/lista")
	public List<Informacao> obterLista(){
		return informacaoService.obterLista();		
	}*/
}