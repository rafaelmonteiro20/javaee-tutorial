package com.roster.commons.dto;

import java.io.Serializable;

public class LigaDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 290368886584321980L;

    private String id;
    private String nome;
    private String esporte;

    public LigaDTO(String id, String nome, String esporte) {
        this.id = id;
        this.nome = nome;
        this.esporte = esporte;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEsporte() {
        return esporte;
    }

    @Override
    public String toString() {
        return "LigaDTO [" + id + ", " + nome + ", " + esporte + "]";
    }

}
