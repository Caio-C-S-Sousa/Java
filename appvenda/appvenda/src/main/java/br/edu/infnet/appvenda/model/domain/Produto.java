package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	@NotNull
	private String descricao;
	@Positive
	private int codigo;	
	@NotNull
	private float preco;	
	@NotNull
	@Column(columnDefinition = "boolean default false")
	private boolean estoque;	
	@ManyToOne
	@JoinColumn(name = "idVendedor")
	private Vendedor vendedor;
	
	@Override
	public String toString() {
		return String.format("%d -  %d - %s - %.2f - %s", id, codigo, descricao, preco, estoque);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEstoque() {
		return estoque;
	}

	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}