package com.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("livrariaPU");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(EntityManager manager) {
		manager.close();
	}
	
}
