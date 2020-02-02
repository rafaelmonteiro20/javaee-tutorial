package com.roster.commons.service;

import java.util.List;

import javax.ejb.Remote;

import com.roster.commons.dto.TimeDTO;

@Remote
public interface TimeService {

    TimeDTO buscaPorId(Long timeId);

    void criaTimeNaLiga(TimeDTO timeDTO, Long ligaId);

    void remove(Long timeId);

    void addJogador(Long jogadorId, Long timeId);

    void removeJogador(Long jogadorId, Long timeId);

    List<TimeDTO> buscaPorLiga(Long ligaId);

}
