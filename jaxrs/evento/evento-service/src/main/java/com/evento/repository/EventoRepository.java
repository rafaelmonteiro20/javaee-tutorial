package com.evento.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.evento.model.Convite;
import com.evento.model.Evento;
import com.evento.model.Pessoa;

public class EventoRepository {

    public Evento salva(Evento evento) {
        return evento;
    }
    
    public List<Evento> buscaTodos() {
        
        Evento evento = new Evento(1L);
        evento.setNome("Meu aniversário");
        evento.setProprietario(new Pessoa("Rafael Monteiro"));
        evento.setLocalizacao("Quixadá");
        evento.setDataHora(LocalDateTime.of(2020, 6, 20, 20, 00));
        
        return Arrays.asList(evento);
    }

    public Evento buscaPorId(Long eventoID) {
        Evento evento = new Evento(eventoID);
        evento.setDataHora(LocalDateTime.now().plusDays(1));
        return evento;
    }
    
    public Evento buscaPorConvite(Convite convite) {
        return null;
    }

}
