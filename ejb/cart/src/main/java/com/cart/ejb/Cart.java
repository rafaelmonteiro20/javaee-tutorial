package com.cart.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Cart {
	
    void init(String cliente) throws LivroException;
    
    void init(String cliente, String id) throws LivroException;
    
    void addLivro(String titulo);
    
    void removeLivro(String titulo) throws LivroException;
    
    List<String> getLivros();
    
    void remove();
    
}
