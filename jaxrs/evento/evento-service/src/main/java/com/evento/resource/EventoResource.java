package com.evento.resource;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.evento.model.Evento;
import com.evento.repository.EventoRepository;

@Path("/eventos")
@RequestScoped
public class EventoResource {

    @Inject
    private EventoRepository eventoRepository;
    
    @GET
    @Produces("application/json")
    public List<Evento> pesquisa() {
        return eventoRepository.buscaTodos();
    }
    
    @POST
    @Consumes("application/json")
    public Response salva(Evento evento) {
        evento = eventoRepository.salva(evento);
        return Response.created(URI.create("/eventos/" + evento.getId())).build();
    }
    
    @GET
    @Path("/{eventoID}")
    @Produces("application/json")
    public Response detalhaEvento(@PathParam("eventoID") Long eventoID) {
        Evento evento = eventoRepository.buscaPorId(eventoID);
        if (evento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(evento).build();
    }
    
}
