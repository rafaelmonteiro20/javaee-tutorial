package com.loja.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(
	@NamedQuery(name = "Item.buscaTodosPorPedido", 
		query = "SELECT i FROM Item i WHERE i.pedido.id = :pedidoID ORDER BY i.id")
)

@Entity
@Table(name = "item")
@IdClass(ItemId.class)
public class Item {

	@Id
	private int id;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "peca_fabricante_id")
	private PecaFabricante peca;
	
	
	public Item() {
		
	}

	public Item(Pedido pedido, int quantidade, PecaFabricante peca) {
		this.id = pedido.getProximoId();
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.peca = peca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public PecaFabricante getPeca() {
		return peca;
	}
	
	public void setPeca(PecaFabricante peca) {
		this.peca = peca;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
