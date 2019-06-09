package com.loja.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.loja.model.Fabricante;

@Stateless
public class FabricanteService {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Fabricante> pesquisaPorNome(String nome) {
	    return manager.createNamedQuery("Fabricante.porNome", Fabricante.class)
	                  .setParameter("nome", nome)
	                  .getResultList();
	}
	
}
