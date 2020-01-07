package com.customer.dao;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import com.customer.model.Cliente;

@Stateless
public class ClienteDao {

    public List<Cliente> buscaTodos() {
        
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Rafael");
        cliente.setEmail("rafael@email.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNome("Francisco");
        cliente2.setEmail("francisco@email.com");
        
        return Arrays.asList(cliente, cliente2); 
    }
    
}
