package com.decorator.service;

import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import com.decorator.model.Funcionario;

@Decorator
public class CalculadoraDeSalarioPlano2020 implements CalculadoraDeSalario {

    @Inject
    private Logger logger;
    
    @Inject @Delegate
    private CalculadoraDeSalario calculadoraDeSalario;
    
    @Override
    public double calcula(Funcionario funcionario) {
        
        logger.info("Calculando salario plano 2020...");
        
        double salario = calculadoraDeSalario.calcula(funcionario);
        return salario * 1.1;
    }

}
