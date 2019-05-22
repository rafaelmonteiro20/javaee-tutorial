package com.cobranca.dao;

import java.util.List;

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

	public List<Titulo> todos() {
		return manager.createQuery("from Titulo t join fetch t.pessoa", Titulo.class)
					.getResultList();
	}
	
}
