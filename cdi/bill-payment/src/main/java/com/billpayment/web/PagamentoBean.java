package com.billpayment.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.billpayment.model.Pagamento;
import com.billpayment.service.PagamentoService;

@Named
@SessionScoped
public class PagamentoBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7130389273118012929L;

    @Inject
    private PagamentoService pagamentoService;
    
    private Pagamento pagamento;

    @PostConstruct
    public void init() {
        pagamento = new Pagamento();
    }

    public String paga() {
        pagamentoService.paga(pagamento);
        return "response";
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

}
