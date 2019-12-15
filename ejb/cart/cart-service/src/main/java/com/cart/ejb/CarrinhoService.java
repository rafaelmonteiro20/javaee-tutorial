package com.cart.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.cart.util.LivroException;

@Stateful
public class CarrinhoService implements Carrinho, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String clienteId;
	private String clienteNome;
	private List<String> livros;

	@Override
	public void init(String cliente) throws LivroException {
		if (cliente == null) {
			throw new LivroException("Cliente é obrigatório.");
		}

		this.clienteNome = cliente;
		this.clienteId = "0";
		this.livros = new ArrayList<>();
	}

	@Override
	public void init(String cliente, String id) throws LivroException {
		if (cliente == null) {
			throw new LivroException("Cliente é obrigatório.");
		}
		this.clienteNome = cliente;

	}

	@Override
	public void addLivro(String titulo) {
		livros.add(titulo);
	}

	@Override
	public void removeLivro(String titulo) throws LivroException {
		boolean removido = livros.remove(titulo);
		if (removido == false) {
			throw new LivroException(titulo + " nao encontrado.");
		}
	}

	@Override
	public List<String> getLivros() {
		return livros;
	}

	@Remove
	@Override
	public void remove() {
		livros = null;
	}
	
	@Override
	public String toString() {
		return clienteId + " - " + clienteNome + " - " + livros;
	}

}
