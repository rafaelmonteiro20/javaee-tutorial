package com.evento.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.evento.model.Pessoa;
import com.evento.repository.PessoaRepository;

@Path("/pessoas")
public class PessoaResource {

    private PessoaRepository pessoaRepository;
    
    @GET
    @Produces("application/json")
    public List<Pessoa> pesquisa() {
        return pessoaRepository.buscaTodas();
    }
    
}
