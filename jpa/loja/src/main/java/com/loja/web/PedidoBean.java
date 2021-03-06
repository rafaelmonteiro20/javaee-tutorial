package com.loja.web;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import com.loja.ejb.PecaService;
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
	
	@EJB
	private PecaService pecaService;
	
	private Pedido pedido;
	private Integer pedidoSelecionado;
	
	private List<Pedido> pedidos;
	private List<Item> itens;
	private List<Peca> pecas;
	
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		pedidos = pedidoService.todosPedidos();
	}
	
	public void salvaPedido() {
		try {
			pedidoService.salvaPedido(pedido);
			pedido = new Pedido();
			init();
		} catch (Exception e) {
			logger.warning("Problema ao criar um novo pedido.");
		}
	}
	
	public void adicionaItem(Peca peca) {
		try {
			pedidoService.addItem(this.pedidoSelecionado, peca.getNumero(), peca.getRevisao(), 1);
			itens = pedidoService.buscaItens(pedidoSelecionado);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Problema ao adicionar item ao pedido {0}", pedidoSelecionado);
		}
	}
	
	public void removePedido(ActionEvent event) {
		try {
			UIParameter param = (UIParameter) event.getComponent().findComponent("removePedidoId");
			Integer id = Integer.parseInt(param.getValue().toString());
			pedidoService.removePedido(id);
			init();
		} catch (NumberFormatException e) {
			logger.warning("Problema na conversao do pedido id.");
		}
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public List<Peca> getPecasEncomentadas() {
		return pecas;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public Integer getPedidoSelecionado() {
		return pedidoSelecionado;
	}
	
	public void setPedidoSelecionado(Integer pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
		this.itens = pedidoService.buscaItens(pedidoSelecionado);
		this.pecas = pecaService.buscaTodasPecas();
	}
	
}
