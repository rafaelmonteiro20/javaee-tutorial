package com.financeiro.service;

import java.time.Year;

import com.financeiro.model.Escolaridade;
import com.financeiro.model.Funcionario;

public class CalculadoraDeSalario {

    public double calcula(Funcionario funcionario) {
        
        double salario = funcionario.getCargo().getSalarioBase();
        Escolaridade escolaridadeFuncionario = funcionario.getEscolaridade();
        Escolaridade escolaridadeCargo = funcionario.getCargo().getEscolaridadeDesejada();

        if (escolaridadeFuncionario.compareTo(escolaridadeCargo) < 0) {
            salario = salario * 0.8;
        } else if (escolaridadeFuncionario.compareTo(escolaridadeCargo) > 0) {
            salario = salario * 1.2;
        }
        
        int anoAtual = getAnoAtual();
        int anoAdmissao = funcionario.getAnoAdmissao();

        double anosTrabalhados = anoAtual - anoAdmissao;
        double aumentoAntiguidade = anosTrabalhados / 100;
        salario = salario * (1 + aumentoAntiguidade);

        if (anosTrabalhados > 5) {
            salario = salario * 1.1;
        }
        
        return salario;
    }

    private int getAnoAtual() {
        return Year.now().getValue();
    }
    
}
