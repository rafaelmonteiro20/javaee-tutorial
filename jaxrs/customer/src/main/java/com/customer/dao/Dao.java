package com.customer.dao;

import java.util.List;

import com.customer.model.Cliente;

public interface Dao<T> {

    List<T> buscaTodos();
    
    Cliente buscaPorId(Integer id);
    
    Cliente salva(Cliente cliente);
    
    boolean remove(Integer id);
    
}
