package com.financeiro.service;

import javax.inject.Inject;

import com.financeiro.model.Funcionario;

public class CalculadoraDeImpostosImpl implements CalculadoraDeImpostos {

    @Inject
    private CalculadoraDeSalario calculadoraDeSalario;

    public CalculadoraDeImpostosImpl() {

    }
    
    public CalculadoraDeImpostosImpl(CalculadoraDeSalario calculadoraDeSalario) {
        this.calculadoraDeSalario = calculadoraDeSalario;
    }

    @Override
    public double calcula(Funcionario funcionario) {

        double salario = calculadoraDeSalario.calcula(funcionario);

        double aliquota = 0.0;
        double parcelaDeduzir = 0.0;

        if (salario <= 1710.78) {
            aliquota = 0.0;
            parcelaDeduzir = 0.0;
        } else if (salario <= 2563.91) {
            aliquota = 7.5 / 100;
            parcelaDeduzir = 128.31;
        } else if (salario <= 3418.59) {
            aliquota = 15.0 / 100;
            parcelaDeduzir = 320.60;
        } else if (salario <= 4271.59) {
            aliquota = 22.5 / 100;
            parcelaDeduzir = 577.0;
        } else {
            aliquota = 27.5 / 100;
            parcelaDeduzir = 790.58;
        }
        
        double impostoSemDesconto = salario * aliquota;
        return impostoSemDesconto - parcelaDeduzir;
    }

}
