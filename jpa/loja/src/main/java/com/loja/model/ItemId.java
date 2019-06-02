package com.loja.model;

import java.io.Serializable;
import java.util.Objects;

public final class ItemId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Integer pedido;

	
	public ItemId() {
	
	}
	
	public ItemId(int id, Integer pedido) {
		this.id = id;
	    this.pedido = pedido;
	}
	
	public int getId() {
		return id;
	}
	
	public Integer getPedido() {
		return pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemId)) {
			return false;
		}
		ItemId other = (ItemId) obj;
		return id == other.id && Objects.equals(pedido, other.pedido);
	}

}
