package com.evento.service;

import javax.inject.Inject;

import com.evento.EventoException;
import com.evento.model.Convite;
import com.evento.model.Evento;
import com.evento.model.StatusConvite;
import com.evento.repository.ConviteRepository;
import com.evento.repository.EventoRepository;

public class ConviteService {

    @Inject
    private ConviteRepository conviteRepository;
    
    @Inject
    private EventoRepository eventoRespository;
    
    public void atualizaStatus(Long conviteID, StatusConvite status) {
        
        Evento evento = eventoRespository.buscaPorConvite(new Convite(conviteID));
        
        if (evento == null) {
            throw new EventoException("Evento não encontrado.");
        }
        
        if (evento.isRealizado()) {
            throw new EventoException("Evento já realizado.");
        }
        
        conviteRepository.atualizaStatus(conviteID, status);
    }
    
}
