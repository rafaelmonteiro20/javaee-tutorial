package com.financeiro.service;

import com.financeiro.model.Funcionario;

public class CalculadoraDeImpostosImpl implements CalculadoraDeImpostos {

    @Override
    public double calcula(Funcionario funcionario) {
        System.out.println("Calculando impostos..");
        return 0;
    }

}
