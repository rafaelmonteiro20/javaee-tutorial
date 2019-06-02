package com.loja.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "peca")
@IdClass(PecaId.class)
public class Peca {

	@Id
	@Column(nullable = false)
	private String numero;

	@Id
	@Column(nullable = false)
	private int revisao;

	private String descricao;

	@Lob
	private String especificacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_revisao")
	private Date dataRevisao;

	@ManyToOne
	@JoinColumns({ 
		@JoinColumn(name = "pai_numero", referencedColumnName = "numero"),
		@JoinColumn(name = "pai_revisao", referencedColumnName = "revisao") 
	})
	private Peca pecaPai;

	@OneToMany(mappedBy = "pecaPai")
	private List<Peca> pecas = new ArrayList<>();

	@OneToOne(mappedBy = "peca")
	private PecaFabricante pecaFabricante;

	
	public Peca() {

	}
	
	public Peca(String numero, int revisao, String descricao, 
				String especificacao, Date dataRevisao) {
		
		this.numero = numero;
		this.revisao = revisao;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.dataRevisao = dataRevisao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getRevisao() {
		return revisao;
	}

	public void setRevisao(int revisao) {
		this.revisao = revisao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public Date getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}

	public Peca getPecaPai() {
		return pecaPai;
	}

	public void setPecaPai(Peca pecaPai) {
		this.pecaPai = pecaPai;
	}

	public List<Peca> getPecas() {
		return pecas;
	}
	
	public void addPeca(Peca peca) {
		peca.setPecaPai(this);
		pecas.add(peca);
	}

	public PecaFabricante getPecaFabricante() {
		return pecaFabricante;
	}
	
	public void setPecaFabricante(PecaFabricante pecaFabricante) {
		this.pecaFabricante = pecaFabricante;
	}

}
