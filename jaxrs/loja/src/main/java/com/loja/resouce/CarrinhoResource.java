package com.loja.resouce;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.loja.dao.CarrinhoDAO;
import com.loja.model.Carrinho;

@Path("/carrinhos")
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca() {
		Carrinho carrinho = new CarrinhoDAO().busca(1L);
		return carrinho.toXML();
	}
	
}