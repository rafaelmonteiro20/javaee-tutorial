package com.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;

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
	private List<Livro> livros;
	
	
	public void salvar() {
		if(livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O livro deve ter pelo menos um autor."));
		} else {
			new Dao<Livro>(Livro.class).salvar(livro);
			novoLivro();
		}
	}
	
	private void novoLivro() {
		livro = new Livro();
		livros = null;	
	}
	
	public void adicionaAutor() {
		Autor autorSelecionado = new Dao<Autor>(Autor.class).buscaPorId(autorId);
		livro.addAutor(autorSelecionado);
	}
	
	public void comecaComDigitoUm(FacesContext context, UIComponent component, 
			Object value) throws ValidatorException {
		
		String isbn = (String) value;
		if(!isbn.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("ISBN deve começar com número 1."));
		}
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
	
	public List<Livro> getLivros() {
		if(livros == null) {
			livros = new Dao<Livro>(Livro.class).listarTodos();
		}
		return livros;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
}
