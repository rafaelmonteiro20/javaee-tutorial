package com.cobranca.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.cobranca.dao.TituloDao;
import com.cobranca.model.Titulo;

@Model
public class ListTitulosBean {

	@Inject
	private TituloDao tituloDao;
	
	private List<Titulo> titulos;
	
	@PostConstruct
	public void init() {
		this.titulos = tituloDao.todos();
	}
	
	public List<Titulo> getTitulos() {
		return titulos;
	}
	
}
