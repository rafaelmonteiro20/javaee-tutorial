package com.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		HttpServer server = Servidor.inicializaServidor();
		System.out.println("Servidor rodando");
        System.in.read();
        server.shutdown();
	}
	
	public static HttpServer inicializaServidor() {
		URI uri = URI.create("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig().packages("com.loja");
		return GrizzlyHttpServerFactory.createHttpServer(uri, config);
	}
	
}
