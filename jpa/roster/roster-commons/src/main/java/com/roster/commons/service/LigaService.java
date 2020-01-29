package com.roster.commons.service;

import java.util.List;

import javax.ejb.Remote;

import com.roster.commons.dto.LigaDTO;

@Remote
public interface LigaService {

    void criaLiga(LigaDTO ligaDTO);

    LigaDTO buscaPorId(Long ligaId);

    void remove(Long ligaId);

    List<LigaDTO> buscaPorJogador(Long jogadorId);

}
