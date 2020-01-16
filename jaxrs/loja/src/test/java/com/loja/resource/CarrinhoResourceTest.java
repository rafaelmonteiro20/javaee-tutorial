package com.loja.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.loja.Servidor;
import com.loja.model.Carrinho;
import com.thoughtworks.xstream.XStream;

public class CarrinhoResourceTest {

	private HttpServer server;
	
	@Before
	public void init() {
		server = Servidor.inicializaServidor();
	}
	
	@Test
	public void deveBuscarCarrinho() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		WebTarget path = target.path("/carrinhos/1");
		String conteudo = path.request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
	@After
	public void destroy() {
		server.shutdown();
	}
	
}
