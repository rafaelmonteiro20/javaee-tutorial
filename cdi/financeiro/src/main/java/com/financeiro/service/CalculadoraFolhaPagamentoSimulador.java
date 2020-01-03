package com.financeiro.service;

import java.util.List;

import com.financeiro.model.Folha;
import com.financeiro.model.Funcionario;
import com.financeiro.service.annotation.Simulador;

@Simulador
public class CalculadoraFolhaPagamentoSimulador implements CalculadoraFolhaPagamento {

    @Override
    public Folha calculaFolha(List<Funcionario> funcionarios) {
        System.out.println("Simulando calculo folha de pagamento...");
        return new Folha(0.0);
    }

}
