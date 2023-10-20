package br.edu.infnet.appvenda.model.domain;

public class Jogo {
	private String plataforma;
	
	private String tipo;
	
	@Override
	public String toString() {
		return String.format("%s - %s", plataforma, tipo);
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}