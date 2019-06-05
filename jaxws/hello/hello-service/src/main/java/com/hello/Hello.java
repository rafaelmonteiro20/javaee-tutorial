package com.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Hello {

	private final String mensagem = "Olá, ";

	@WebMethod
    public String digaOla(String nome) {
        return mensagem + nome + "!";
    }
	
}
