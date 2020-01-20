package com.financeiro.service;

import javax.enterprise.inject.Alternative;

import com.financeiro.model.Funcionario;

@Alternative
public class CalculadoraDeSalarioPlano2020 implements CalculadoraDeSalario {

    @Override
    public double calcula(Funcionario funcionario) {
        return funcionario.getCargo().getSalarioBase() * 1.25;
    }

}
