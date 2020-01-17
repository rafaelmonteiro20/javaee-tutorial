package com.billpayment.service;

import java.util.logging.Logger;

import com.billpayment.model.Pagamento;

public class PagamentoService {

    private static final Logger logger = Logger.getLogger(PagamentoService.class.getCanonicalName());
    
    public void paga(Pagamento pagamento) {
        logger.info("Realizando pagamento...");
    }
    
}
