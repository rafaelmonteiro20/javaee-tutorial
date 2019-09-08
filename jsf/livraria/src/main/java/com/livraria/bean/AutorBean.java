package com.livraria.bean;

import javax.faces.bean.ManagedBean;

import com.livraria.model.Autor;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	
	public void salvar() {
		System.out.println("Salvando autor " + autor.getNome());
	}
	
	public Autor getAutor() {
		return autor;
	}
	
}
