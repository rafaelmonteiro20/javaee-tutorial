package com.estoque.model;

public class Item {

	private String sku;

	private String nome;

	private Integer quantidade;

	private String tipo;

	
	public Item(String sku, String nome, Integer quantidade, String tipo) {
		this.sku = sku;
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
