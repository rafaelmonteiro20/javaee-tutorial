package com.roster.commons.service;

import java.util.List;

import javax.ejb.Remote;

import com.roster.commons.dto.JogadorDTO;

@Remote
public interface JogadorService {

    void criaJogador(String id, String nome, String posicao, double salario);

    List<JogadorDTO> buscaTodos();
    
    JogadorDTO buscaPorId(Long jogadorId);
    
    void remove(Long jogadorId);
   
    List<JogadorDTO> buscaPorCidade(String cidade);

    List<JogadorDTO> buscaPorMaiorSalario(String nome);
    
    List<JogadorDTO> buscaPorLiga(Long ligaId);

    List<JogadorDTO> buscaPorPosicao(String posicao);
   
    List<JogadorDTO> buscaPorPosicaoENome(String position, String name);

    List<JogadorDTO> buscaPorSalario(double minimo, double maximo);
    
    List<JogadorDTO> buscaPorEsporte(String esporte);
    
    List<JogadorDTO> buscaJogadoresSemTime();

    List<JogadorDTO> buscaPorTime(String timeId);

    List<String> buscaEsportesDoJogador(Long jogadorId);

}
