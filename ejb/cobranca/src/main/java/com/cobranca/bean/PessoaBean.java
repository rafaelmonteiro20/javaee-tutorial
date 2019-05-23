package com.cobranca.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.cobranca.model.Pessoa;
import com.cobranca.service.PessoaService;

@Model
public class PessoaBean {

	@Inject
	private PessoaService pessoaService;
	
	private List<Pessoa> pessoas;
	
	private Pessoa pessoa;
	
	@PostConstruct
	public void init() {
		this.pessoas = pessoaService.todas();
		this.pessoa = new Pessoa();
	}
	
	public void salva() {
		this.pessoaService.salva(pessoa);
		init();
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
}
