package com.billpayment.model;

import java.math.BigDecimal;
import java.util.Date;

public class Pagamento {

    private Date data;

    private BigDecimal valor;

    private TipoPagamento tipoPagamento = TipoPagamento.DEBITO;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
}
