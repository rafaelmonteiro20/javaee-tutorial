package com.decorator.service;

import com.decorator.model.Escolaridade;
import com.decorator.model.Funcionario;

public class CalculadoraDeSalarioPlano2005 implements CalculadoraDeSalario {

    @Override
    public double calcula(Funcionario funcionario) {
        
        double salario = funcionario.getCargo().getSalarioBase();
        Escolaridade escolaridadeFuncionario = funcionario.getEscolaridade();
        Escolaridade escolaridadeCargo = funcionario.getCargo().getEscolaridadeDesejada();

        if (escolaridadeFuncionario.compareTo(escolaridadeCargo) < 0) {
            salario = salario * 0.8;
        } else if (escolaridadeFuncionario.compareTo(escolaridadeCargo) > 0) {
            salario = salario * 1.2;
        }
        
        return salario;
    }
    
}
