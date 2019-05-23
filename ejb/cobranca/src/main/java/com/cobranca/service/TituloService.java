package com.cobranca.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.cobranca.dao.TituloDao;
import com.cobranca.model.Titulo;

@Stateless
public class TituloService {

	@Inject
	private TituloDao tituloDao;
	
	public void salva(Titulo titulo) {
		tituloDao.salva(titulo);
	}
	
}
