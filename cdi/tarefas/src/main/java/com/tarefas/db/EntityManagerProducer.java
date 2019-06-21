package com.tarefas.db;

import javax.ejb.Singleton;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Singleton
public class EntityManagerProducer {

	@PersistenceUnit(unitName = "defaultDS")
	private EntityManagerFactory factory;

	@Produces
	@BDProducao
	public EntityManager cria() {
		return factory.createEntityManager();
	}

	public void close(@Disposes @BDProducao EntityManager manager) {
		manager.close();
	}

}
