package com.cart.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.cart.util.LivroException;

@Remote
public interface Carrinho {
	
    void init(String cliente) throws LivroException;
    
    void init(String cliente, String id) throws LivroException;
    
    void addLivro(String titulo);
    
    void removeLivro(String titulo) throws LivroException;
    
    List<String> getLivros();
    
    void remove();
    
}
