package com.customer.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.customer.model.Cliente;

@Model
public class ClienteBean {

    private Client clientRest;
    
    @PostConstruct
    private void init() {
        this.clientRest = ClientBuilder.newClient();
    }
    
    public List<Cliente> buscaTodosClientes() {
        List<Cliente> clientes = 
                this.clientRest.target("http://localhost:8080/customer/services/clientes")
                .request(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Cliente>>() {});
        
        return clientes;
    }
    
    @PreDestroy
    private void clean() {
        clientRest.close();
    }
    
}
