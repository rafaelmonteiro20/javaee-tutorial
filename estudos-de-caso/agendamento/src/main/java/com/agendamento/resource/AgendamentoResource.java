package com.agendamento.resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.agendamento.service.AgendamentoService;

@Named
@Path("/agenda")
public class AgendamentoResource {

	@Inject
	private AgendamentoService agendamentoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaTodos() {
		List<String> agendamentos = agendamentoService.buscaTodos();
		return Response.ok(agendamentos).build();
	}
	
}
