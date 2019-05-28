package com.loja.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	private Integer id;

	private char status;

	private int desconto;

	private String informacaoEntrega;

	@Temporal(TemporalType.TIME)
	@Column(name = "ultima_atualizacao")
	private Date ultimaAtualizacao;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Collection<Item> itens = new ArrayList<>();

	public Pedido() {
		this.ultimaAtualizacao = new Date();
	}

	public Pedido(Integer id, char status, int desconto, String informacaoEntrega) {
		this.id = id;
		this.status = status;
		this.desconto = desconto;
		this.informacaoEntrega = informacaoEntrega;
		this.ultimaAtualizacao = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public String getInformacaoEntrega() {
		return informacaoEntrega;
	}

	public void setInformacaoEntrega(String informacaoEntrega) {
		this.informacaoEntrega = informacaoEntrega;
	}

	public Collection<Item> getItens() {
		return itens;
	}

	public int getProximoId() {
		return this.itens.size() + 1;
	}

}
