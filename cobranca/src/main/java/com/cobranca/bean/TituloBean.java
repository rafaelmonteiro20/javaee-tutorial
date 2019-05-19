package com.cobranca.bean;

import javax.enterprise.inject.Model;

import com.cobranca.model.StatusTitulo;
import com.cobranca.model.Titulo;

@Model
public class TituloBean {

	private Titulo titulo = new Titulo();
	
	public void salva() {
		
	}
	
	public StatusTitulo[] getStatuses() {
		return StatusTitulo.values();
	}
	
	public Titulo getTitulo() {
		return titulo;
	}
	
}
