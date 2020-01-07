package com.customer.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.customer.dao.ClienteDao;
import com.customer.model.Cliente;

@Stateless
@Path("/clientes")
public class ClienteResource {

    @EJB
    private ClienteDao clienteDao;
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Cliente> buscaTodos() {
        return clienteDao.buscaTodos();
    }
    
}
