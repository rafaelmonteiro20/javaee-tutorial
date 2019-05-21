package com.cobranca.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cobranca.model.Titulo;

@Stateless
public class TituloDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Titulo titulo) {
		manager.persist(titulo);
	}
	
}
