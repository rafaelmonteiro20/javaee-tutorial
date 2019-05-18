package com.cobranca.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.cobranca.model.Pessoa;
import com.cobranca.service.PessoaService;

@Model
public class PessoaBean {

	@Inject
	private PessoaService pessoaService;
	
	private Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public void init() {
		
	}
	
	public void salva() {
		pessoaService.salva(pessoa);
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
}
