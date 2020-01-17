package com.billpayment.model;

public enum TipoPagamento {

    DEBITO("Débito"),
    CREDITO("Crédito");
    
    private String descricao;
    
    private TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
