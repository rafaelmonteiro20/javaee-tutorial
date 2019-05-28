package com.loja.model;

import java.io.Serializable;
import java.util.Objects;

public final class ItemId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pedidoId;
	private int itemId;

	public ItemId() {
	
	}
	
	public ItemId(Integer pedidoId, int itemId) {
	    this.pedidoId = pedidoId;
	    this.itemId = itemId;
	}
	
	public Integer getPedidoId() {
		return pedidoId;
	}
	
	public int getItemId() {
		return itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedidoId, itemId);
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
		return Objects.equals(pedidoId, other.pedidoId)
					&& itemId == other.itemId;
	}

	@Override
	public String toString() {
		return pedidoId + "-" + itemId;
	}
	  
}
