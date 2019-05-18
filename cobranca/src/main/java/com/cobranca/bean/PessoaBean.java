package com.cobranca.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import com.cobranca.model.Pessoa;

@Model
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public void init() {
		
	}
	
	public void salva() {
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
}
