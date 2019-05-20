package com.cobranca.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.cobranca.dao.PessoaDao;
import com.cobranca.model.Pessoa;
import com.cobranca.model.StatusTitulo;
import com.cobranca.model.Titulo;

@Model
public class TituloBean {

	@Inject
	private PessoaDao pessoaDao;
	
	private List<Pessoa> pessoas;
	
	private Titulo titulo = new Titulo();
	
	@PostConstruct
	public void init() {
		this.pessoas = pessoaDao.todas();
	}
	
	public void salva() {

	}
	
	public StatusTitulo[] getStatuses() {
		return StatusTitulo.values();
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Titulo getTitulo() {
		return titulo;
	}
	
}
