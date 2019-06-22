package com.loja.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.loja.model.Fabricante;
import com.loja.model.Item;
import com.loja.model.Peca;
import com.loja.model.PecaFabricante;
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
	
	public void criaPeca(String numero, int revisao, String descricao,
        String especificacao, Date dataRevisao) {
        
		try {
            Peca peca = new Peca(numero, revisao, descricao, especificacao, dataRevisao);
            manager.persist(peca);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
	
	 public void addPecaAListaDeMateriais(String numeroPecaPai, int revisaoPecaPai,
	            String numero, int revisao) {
		 
		try {
			Peca pecaPai = manager.find(Peca.class, new PecaId(numeroPecaPai, revisaoPecaPai));
			Peca peca = manager.find(Peca.class, new PecaId(numero, revisao));
			pecaPai.addPeca(peca);
		} catch (EJBException e) {
		
		}
	}

	public void criaFabricante(Integer id, String nome, String endereco, 
			String contato, String telefone) {
		
		try {
			Fabricante fabricante = new Fabricante(id, nome, endereco, contato, telefone);
			manager.persist(fabricante);
		} catch (Exception e) {
            throw new EJBException(e);
        }
	}

	public void criaPecaFabricante(String numeroPeca, int revisao, String descricao, 
			double preco, Integer fabricanteId) {
		
		try {
            Peca peca = manager.find(Peca.class, new PecaId(numeroPeca, revisao));
            
            PecaFabricante pecaFabricante = new PecaFabricante(descricao, preco, peca);
            manager.persist(pecaFabricante);
            
            Fabricante fabricante = manager.find(Fabricante.class, fabricanteId);
            fabricante.addPeca(pecaFabricante);
           
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
		
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

	public List<Peca> buscaTodasPecas() {
		return manager.createNamedQuery("Peca.buscaTodas", Peca.class)
					.getResultList();
	}

}
