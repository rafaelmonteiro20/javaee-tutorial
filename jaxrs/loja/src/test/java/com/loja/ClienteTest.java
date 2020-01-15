package com.loja;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void conexaoComServidor() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		WebTarget path = target.path("/v2/52aaf5deee7ba8c70329fb7d");
		String conteudo = path.request().get(String.class);
		assertTrue(conteudo.contains("<rua>Rua Vergueiro 3185"));
	}
	
}
