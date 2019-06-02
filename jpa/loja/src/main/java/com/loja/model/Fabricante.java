package com.loja.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	private Integer id;

	private String nome;

	private String endereco;

	private String contato;

	private String telefone;

	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL)
	private Collection<PecaFabricante> pecas = new ArrayList<>();

	public Fabricante() {

	}

	public Fabricante(Integer id, String nome, String endereco, String contato, String telefone) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Collection<PecaFabricante> getPecas() {
		return pecas;
	}

	public void addPeca(PecaFabricante peca) {
		peca.setFabricante(this);
		this.pecas.add(peca);
	}

}
