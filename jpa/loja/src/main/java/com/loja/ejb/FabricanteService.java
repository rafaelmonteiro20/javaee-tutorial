package com.loja.ejb;

import java.util.List;

import javax.ejb.EJBException;
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

	public void criaFabricante(Integer id, String nome, String endereco, String contato, 
			String telefone) {

		try {
			Fabricante fabricante = new Fabricante(id, nome, endereco, contato, telefone);
			manager.persist(fabricante);
		} catch (Exception e) {
			throw new EJBException(e);
		}
	}

}
