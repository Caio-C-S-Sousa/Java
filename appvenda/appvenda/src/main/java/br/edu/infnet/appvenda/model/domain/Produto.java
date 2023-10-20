package br.edu.infnet.appvenda.model.domain;

public class Produto {
	private String descricao;
	
	private int codigo;
	
	private float preco;
	
	private boolean estoque;

	@Override
	public String toString() {
		return String.format("%d - %s - %.2f - %s", codigo , descricao, preco, estoque);
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
}