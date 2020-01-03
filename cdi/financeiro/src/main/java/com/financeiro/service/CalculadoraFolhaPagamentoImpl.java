package com.financeiro.service;

import java.util.List;

import com.financeiro.model.Folha;
import com.financeiro.model.Funcionario;

public class CalculadoraFolhaPagamentoImpl implements CalculadoraFolhaPagamento {

    @Override
    public Folha calculaFolha(List<Funcionario> funcionarios) {
        System.out.println("Calculando folha pagamento real...");
        return new Folha(5400.0);
    }

}
