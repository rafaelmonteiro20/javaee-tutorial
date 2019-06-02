package com.loja.web;

import java.io.Serializable;
import java.util.List;

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
	
	@EJB
	private PedidoService pedidoService;

	private Integer pedidoSelecionado;
	
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
	
	public Integer getPedidoSelecionado() {
		return pedidoSelecionado;
	}
	
	public void setPedidoSelecionado(Integer pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}
	
}
