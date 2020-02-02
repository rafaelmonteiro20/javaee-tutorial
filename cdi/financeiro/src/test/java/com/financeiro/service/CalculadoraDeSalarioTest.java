package com.financeiro.service;

import static org.junit.Assert.*;

import java.time.Year;

import org.junit.Before;
import org.junit.Test;

import com.financeiro.model.Escolaridade;
import com.financeiro.model.Funcionario;
import com.financeiro.model.builder.FuncionarioBuilder;

public class CalculadoraDeSalarioTest {

    private CalculadoraDeSalario calculadora;
    
    @Before
    public void init() {
        this.calculadora = new CalculadoraDeSalarioPlano2005();
    }
    
    @Test
    public void calculaSalarioComEscolaridadeDesejada() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(1000.0)
                .build();
        
        assertEquals(1000.0, calculadora.calcula(funcionario), 0.0001);
    }
    
    @Test
    public void calculaSalarioComEscolaridadeInferiorADesejada() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comEscolaridade(Escolaridade.SUPERIOR)
                .comEscolaridadeDesejada(Escolaridade.POS_GRADUACAO)
                .comSalarioBaseDe(2000.0)
                .build();
        
        assertEquals(1600.0, calculadora.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaSalarioComEscolaridadeSuperiorADesejada() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comEscolaridade(Escolaridade.MESTRADO)
                .comEscolaridadeDesejada(Escolaridade.SUPERIOR)
                .comSalarioBaseDe(3000.0)
                .build();
        
        assertEquals(3600.0, calculadora.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaSalarioComAumentoAntiguidadeDe2Anos() {
        Funcionario funcionario = new FuncionarioBuilder()
                .admitidoEm(Year.now().minusYears(2).getValue())
                .comSalarioBaseDe(3000.0)
                .build();
        
        assertEquals(3060.0, calculadora.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaSalarioComMaisDeCincoAnosTrabalhados() {
        Funcionario funcionario = new FuncionarioBuilder()
                .admitidoEm(Year.now().minusYears(6).getValue())
                .comSalarioBaseDe(2000.0) // 2120
                .build();
        
        assertEquals(2332.0, calculadora.calcula(funcionario), 0.0001);
    }
    
}
