package com.livraria.bean;

import javax.faces.bean.ManagedBean;

import com.livraria.dao.Dao;
import com.livraria.model.Autor;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	
	public void salvar() {
		new Dao<Autor>(Autor.class).salvar(autor);
	}
	
	public Autor getAutor() {
		return autor;
	}
	
}
