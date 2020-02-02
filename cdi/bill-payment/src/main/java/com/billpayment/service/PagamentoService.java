package com.billpayment.service;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.billpayment.event.PagamentoEvent;
import com.billpayment.model.Pagamento;
import com.billpayment.service.annotation.Credito;
import com.billpayment.service.annotation.Debito;

public class PagamentoService implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(PagamentoService.class.getCanonicalName());
    
    @Inject @Credito
    private Event<PagamentoEvent> creditoRealizadoEvent;

    @Inject @Debito
    private Event<PagamentoEvent> debitoRealizadoEvent;
    
    public void paga(Pagamento pagamento) {
        logger.info("Realizando pagamento...");
    
        pagamento.setData(new Date());
        
        if (pagamento.isDebito()) {
            debitoRealizadoEvent.fire(new PagamentoEvent(pagamento));
        } else {
            creditoRealizadoEvent.fire(new PagamentoEvent(pagamento));
        }
    }
    
}
