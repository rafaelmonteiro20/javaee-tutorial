package com.evento.model;

public enum StatusConvite {

    NAO_RESPONDIDO("Não Respondido"), 
    VOU("Vou"), 
    NAO_VOU("Não Vou");

    private final String descricao;

    private StatusConvite(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
