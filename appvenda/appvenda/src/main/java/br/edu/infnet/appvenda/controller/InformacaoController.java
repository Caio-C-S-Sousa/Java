package br.edu.infnet.appvenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformacaoController {

	@PostMapping(value = "/informacao/incluir")
	public String Incluir(String campo, String descricao) {
		
		
		System.out.println("campo: "+ campo + " desc: " + descricao);
		
		return "redirect:/";
	}
}