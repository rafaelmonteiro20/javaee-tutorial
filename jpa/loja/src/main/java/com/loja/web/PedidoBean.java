package com.loja.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.loja.model.Item;
import com.loja.model.Peca;

@ManagedBean
@SessionScoped
public class PedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void adicionaItem() {
		
	}
	
	public List<Item> getItens() {
		return null;
	}
	
	public List<Peca> getPecasEncomentadas() {
		return null;
	}
	
}
