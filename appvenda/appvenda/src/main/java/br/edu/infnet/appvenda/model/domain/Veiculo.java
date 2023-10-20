package br.edu.infnet.appvenda.model.domain;

public class Veiculo {
	private String marca;
	
	private int ano;
	
	private int portas;
	
	private String modelo;
	
	@Override
	public String toString() {
		return String.format("%s - %o - %o - %s", marca, portas, ano, modelo);
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
}