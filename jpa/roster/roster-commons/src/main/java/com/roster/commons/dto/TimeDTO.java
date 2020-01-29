package com.roster.commons.dto;

import java.io.Serializable;

public class TimeDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1618941013515364318L;

    private String id;
    private String nome;
    private String cidade;

    public TimeDTO(String id, String nome, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Time DTO [" + id + ", " + nome + ", " + cidade + "]";
    }

}
