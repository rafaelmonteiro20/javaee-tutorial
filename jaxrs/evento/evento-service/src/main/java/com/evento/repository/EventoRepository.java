package com.evento.repository;

import java.util.ArrayList;
import java.util.List;

import com.evento.model.Evento;

public class EventoRepository {

    public Evento salva(Evento evento) {
        return evento;
    }
    
    public List<Evento> buscaTodos() {
        return new ArrayList<>();
    }

    public Evento buscaPorId(Long eventoID) {
        return new Evento(eventoID);
    }

}
