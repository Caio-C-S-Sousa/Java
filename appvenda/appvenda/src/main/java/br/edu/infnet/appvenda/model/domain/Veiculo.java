package br.edu.infnet.appvenda.model.domain;

public class Veiculo extends Produto {
	private String marca;
	
	private int ano;
	
	private int portas;
	
	private String modelo;
	
	@Override
	public String toString() {
		return String.format("%s - %d - %s - %d - %s", super.toString(), ano, marca, portas, modelo);
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