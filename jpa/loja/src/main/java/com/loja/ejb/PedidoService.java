package com.loja.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.loja.model.Item;
import com.loja.model.Peca;
import com.loja.model.PecaId;
import com.loja.model.Pedido;

@Stateful
public class PedidoService {

	@PersistenceContext
	private EntityManager manager;

	public List<Pedido> todosPedidos() {
		return manager.createNamedQuery("Pedido.buscaTodos", Pedido.class)
					.getResultList();
	}

	public void criaPedido(Integer pedidoId, char status, int desconto, String informacaoEntrega) {
		this.salvaPedido(new Pedido(pedidoId, status, desconto, informacaoEntrega));
	}

	public void salvaPedido(Pedido pedido) {
		try {
			manager.persist(pedido);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public void addItem(Integer pedidoId, String numeroPeca, int revisao, int quantidade) {
		try {
			Pedido pedido = manager.find(Pedido.class, pedidoId);
			Peca peca = manager.find(Peca.class, new PecaId(numeroPeca, revisao));

			Item item = new Item(pedido, quantidade, peca.getPecaFabricante());
			pedido.addItem(item);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public void removePedido(Integer id) {
		try {
			Pedido pedido = manager.find(Pedido.class, id);
			manager.remove(pedido);
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}

	public List<Item> buscaItens(Integer pedidoID) {
		return manager.createNamedQuery("Item.buscaTodosPorPedido", Item.class)
					.setParameter("pedidoID", pedidoID)
					.getResultList();
	}

}
