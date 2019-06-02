package com.loja.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.loja.model.Pedido;

@Stateful
public class PedidoService {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Pedido> todosPedidos() {
		return manager.createNamedQuery("Pedido.buscaTodos", Pedido.class)
					.getResultList();
	}
	
}
