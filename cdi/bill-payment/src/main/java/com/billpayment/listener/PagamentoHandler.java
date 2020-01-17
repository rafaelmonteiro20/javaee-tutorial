package com.billpayment.listener;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

import com.billpayment.event.PagamentoEvent;
import com.billpayment.service.annotation.Credito;
import com.billpayment.service.annotation.Debito;

@SessionScoped
public class PagamentoHandler implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2013564481486393525L;

    private static final Logger logger = Logger.getLogger(PagamentoHandler.class.getCanonicalName());

    public void pagamentoCredito(@Observes @Credito PagamentoEvent evento) {
        logger.log(Level.INFO, "PagamentoHandler - credito realizado: {0}", evento.getPagamento());
    }

    public void pagamentoDebito(@Observes @Debito PagamentoEvent evento) {
        logger.log(Level.INFO, "PagamentoHandler - debito realizado: {0}", evento.getPagamento());
    }
    
}
