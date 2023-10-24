package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Transforma vendedor em tabela
@Table(name = "TVendedor") // Nome da tabela no banco
public class Vendedor 
{
	@Id
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private List<Produto> produtos;
		
	@Override
	public String toString() {
		return String.format("%s - %s - %s", nome, cpf, email);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}