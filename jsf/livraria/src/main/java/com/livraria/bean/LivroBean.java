package com.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.livraria.dao.Dao;
import com.livraria.model.Autor;
import com.livraria.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Livro livro = new Livro();
	private Integer autorId;
	private List<Autor> autores;
	
	
	public void salvar() {
		if(livro.getAutores().isEmpty()) {
			throw new RuntimeException("O livro deve ter pelo menos um autor.");
		}
		new Dao<Livro>(Livro.class).salvar(livro);
	}
	
	public void adicionaAutor() {
		Autor autorSelecionado = new Dao<Autor>(Autor.class).buscaPorId(autorId);
		livro.addAutor(autorSelecionado);
	}

	public Livro getLivro() {
		return livro;
	}
	
	public List<Autor> getAutores() {
		if(autores == null) {
			autores = new Dao<Autor>(Autor.class).listarTodos();
		}
		return autores;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
}
