package com.financeiro.service;

import java.util.List;

import com.financeiro.model.Folha;
import com.financeiro.model.Funcionario;
import com.financeiro.model.PlanoDeCargos;
import com.financeiro.service.annotation.Simulador;

@Simulador(planoDeCargos = PlanoDeCargos.VERSAO_2020)
public class CalculadoraFolhaPagamentoSimulador2020 implements CalculadoraFolhaPagamento {

    @Override
    public Folha calculaFolha(List<Funcionario> funcionarios) {
        System.out.println("Simulando calculo folha de pagamento simulador 2020...");
        return new Folha(0.0);
    }

}
