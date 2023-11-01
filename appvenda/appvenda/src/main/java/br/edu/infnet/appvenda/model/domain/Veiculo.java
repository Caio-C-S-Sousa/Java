package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TVeiculo")
public class Veiculo extends Produto {
	@NotNull
	@Size(min = 2, max = 100, message = "A marca deve ter entre {min} e {max} caracteres.")
	private String marca;
	@Positive
	private int ano;
	@Positive
	private int portas;
	@NotNull
	private String modelo;
	@NotNull
	private String chassi;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %d - %s - %d - %s", super.toString(), chassi, ano, marca, portas, modelo);
	}
	
	public String getModelo() {
		return modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
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