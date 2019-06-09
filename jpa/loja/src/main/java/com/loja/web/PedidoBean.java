package com.loja.web;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.loja.ejb.PedidoService;
import com.loja.model.Item;
import com.loja.model.Peca;
import com.loja.model.Pedido;

@ManagedBean
@SessionScoped
public class PedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger("com.loja.web.PedidoBean");
	
	@EJB
	private PedidoService pedidoService;
	
	private Pedido pedido;

	private Integer pedidoSelecionado;
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
	}
	
	
	public void salvaPedido() {
		try {
			pedidoService.salvaPedido(pedido);
			pedido = new Pedido();
        } catch (Exception e) {
            logger.warning("Problema ao criar um novo pedido.");
        }
	}
	
	public void adicionaItem() {
		
	}
	
	public void removePedido() {
		
	}
	
	public List<Pedido> getPedidos() {
		return pedidoService.todosPedidos();
	}
	
	public List<Item> getItens() {
		return null;
	}
	
	public List<Peca> getPecasEncomentadas() {
		return null;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public Integer getPedidoSelecionado() {
		return pedidoSelecionado;
	}
	
	public void setPedidoSelecionado(Integer pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}
	
}
