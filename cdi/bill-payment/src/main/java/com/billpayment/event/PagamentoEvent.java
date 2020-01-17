package com.billpayment.event;

import java.io.Serializable;

import com.billpayment.model.Pagamento;

public class PagamentoEvent implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6407967360613478424L;
    
    private Pagamento pagamento;

    public PagamentoEvent(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }

}
