package com.livraria.bean;

import javax.faces.bean.ManagedBean;

import com.livraria.model.Livro;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();

	public void salvar() {
		System.out.println("Salvando livro " + livro.getTitulo());
	}

	public Livro getLivro() {
		return livro;
	}

}
