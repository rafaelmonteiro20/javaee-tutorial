package com.customer.resource;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response buscaPorId(@PathParam("id") int id) {
        Cliente cliente = clienteDao.buscaPorId(id);
        if (cliente == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response salva(Cliente cliente) {
        cliente = clienteDao.salva(cliente);
        return Response.created(URI.create("/" + cliente.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response atualiza(@PathParam("id") int id, Cliente cliente) {

        Cliente existente = clienteDao.buscaPorId(id);
        if (existente == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        
        cliente.setId(id);
        clienteDao.salva(cliente);
        return Response.ok().status(303).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Integer id) {
        if (!clienteDao.remove(id)) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

}
