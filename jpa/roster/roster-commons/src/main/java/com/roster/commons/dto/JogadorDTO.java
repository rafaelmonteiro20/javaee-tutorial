package com.roster.commons.dto;

import java.io.Serializable;

public class JogadorDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5352446961599198526L;

    private String id;
    private String nome;
    private String posicao;
    private double salario;

    public JogadorDTO() {

    }

    public JogadorDTO(String id, String nome, String posicao, double salario) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Jogador DTO [" + id + ", " + nome + ", " + posicao + ", " + salario + "]";
    }

}
