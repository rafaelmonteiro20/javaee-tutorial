package com.customer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.customer.model.Cliente;

@Startup
@Singleton
@Local(ClienteDao.class)
public class ClienteDao implements Dao<Cliente> {

    private AtomicInteger idCliente = new AtomicInteger(1);
    
    public Map<Integer, Cliente> clientes = new HashMap<>();
    
    @PostConstruct
    public void init() {
        salva(new Cliente("Rafael Monteiro", "rafael@email.com"));
        salva(new Cliente("Ana", "ana@email.com"));
        salva(new Cliente("Francisco", "francisco@email.com"));
    }
    
    @Override
    public List<Cliente> buscaTodos() {
        return new ArrayList<>(clientes.values()); 
    }

    @Override
    public Cliente buscaPorId(Integer id) {
        return clientes.get(id);
    }
    
    @Override
    public Cliente salva(Cliente cliente) {
        int proximoID = idCliente.getAndIncrement();
        cliente.setId(proximoID);
        return clientes.put(proximoID, cliente);
    }

    @Override
    public boolean remove(Integer id) {
        Cliente cliente = buscaPorId(id);
        if (cliente == null) {
            return false;
        }
        return clientes.remove(id, cliente);
    }
    
}
