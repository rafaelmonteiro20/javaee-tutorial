package com.livraria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> {

	private final Class<T> clazz;
	
	public Dao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void salvar(T entity) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<T> listarTodos() {
		EntityManager manager = getEntityManager();
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(clazz);
		
		List<T> resultado = manager.createQuery(query).getResultList();
		manager.close();
		
		return resultado;
	}
	
	private EntityManager getEntityManager() {
		return new JpaUtil().getEntityManager();
	}
	
}
