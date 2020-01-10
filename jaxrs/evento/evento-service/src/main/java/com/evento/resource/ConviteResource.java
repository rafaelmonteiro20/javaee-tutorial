package com.evento.resource;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.evento.EventoException;
import com.evento.model.StatusConvite;
import com.evento.service.ConviteService;

@Path("/convites")
public class ConviteResource {

    @Inject
    private ConviteService conviteService;
    
    @PUT
    @Path("/{conviteID}/vou")
    public Response vou(@PathParam("conviteID") Long conviteID) {
        return atualizaStatus(conviteID, StatusConvite.VOU);
    }

    @PUT
    @Path("/{conviteID}/nao-vou")
    public Response naoVou(@PathParam("conviteID") Long conviteID) {
        return atualizaStatus(conviteID, StatusConvite.NAO_VOU);
    }
    
    private Response atualizaStatus(Long conviteID, StatusConvite status) {
        try {
            conviteService.atualizaStatus(conviteID, status);
            return Response.noContent().build();
        } catch (EventoException e) {
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    
}
