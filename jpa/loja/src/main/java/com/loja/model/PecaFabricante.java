package com.loja.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "peca_fabricante")
public class PecaFabricante {

	@Id
	private Long numeroPeca;

	private String descricao;

	private double preco;

	@OneToOne
	@JoinColumns({ 
		@JoinColumn(name = "peca_numero", referencedColumnName = "numero"),
		@JoinColumn(name = "peca_revisao", referencedColumnName = "revisao") 
	})
	private Peca peca;

	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

	public PecaFabricante() {

	}

	public PecaFabricante(String descricao, double preco, Peca peca) {
		this.descricao = descricao;
		this.preco = preco;
		this.peca = peca;
		this.peca.setPecaFabricante(this);
	}

	public Long getNumeroPeca() {
		return numeroPeca;
	}

	public void setNumeroPeca(Long numeroPeca) {
		this.numeroPeca = numeroPeca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
}
