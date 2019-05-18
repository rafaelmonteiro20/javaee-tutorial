package com.cobranca.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cobranca.model.Pessoa;

@Stateless
public class PessoaDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Pessoa pessoa) {
		manager.persist(pessoa);
	}
	
}
