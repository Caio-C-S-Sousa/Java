package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TJogo")
public class Jogo extends Produto {
	private String nome;
	
	private String plataforma;
	
	private String tipo;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), nome, plataforma, tipo);
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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