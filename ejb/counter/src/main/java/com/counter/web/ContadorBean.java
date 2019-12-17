package com.counter.web;

import javax.ejb.EJB;
import javax.inject.Named;

import com.counter.ejb.ContadorService;

@Named
public class ContadorBean {

	@EJB
	private ContadorService contadorService;
	
	public int getHits() {
		return contadorService.getHits();
	}
	
}
