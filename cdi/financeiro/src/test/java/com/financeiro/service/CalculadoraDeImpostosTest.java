package com.financeiro.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.financeiro.model.Funcionario;
import com.financeiro.model.builder.FuncionarioBuilder;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraDeImpostosTest {

    @Mock
    private CalculadoraDeSalario calculadoraDeSalario;
    
    private CalculadoraDeImpostos calculadoraDeImpostos;
    
    @Before
    public void init() {
        this.calculadoraDeImpostos = new CalculadoraDeImpostosImpl(calculadoraDeSalario);
    }
    
    @Test
    public void impostoZeradoQuandoNaoCaiEmUmaFaixaDeContribuicao() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(1500.0)
                .build();
        
        Mockito.when(calculadoraDeSalario.calcula(funcionario)).thenReturn(1500.0);
        assertEquals(0.0, calculadoraDeImpostos.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaIRNaPrimeiraFaixaDeContribuicao() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(2000.0)
                .build();
        
        Mockito.when(calculadoraDeSalario.calcula(funcionario)).thenReturn(2000.0);
        assertEquals(21.69, calculadoraDeImpostos.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaIRNaSegundaFaixaDeContribuicao() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(3000.0)
                .build();
        
        Mockito.when(calculadoraDeSalario.calcula(funcionario)).thenReturn(3000.0);
        assertEquals(129.4, calculadoraDeImpostos.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaIRNaTerceiraFaixaDeContribuicao() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(4000.0)
                .build();
        
        Mockito.when(calculadoraDeSalario.calcula(funcionario)).thenReturn(4000.0);
        assertEquals(323.0, calculadoraDeImpostos.calcula(funcionario), 0.0001);
    }

    @Test
    public void calculaIRNaQuartaFaixaDeContribuicao() {
        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(6000.0)
                .build();
        
        Mockito.when(calculadoraDeSalario.calcula(funcionario)).thenReturn(6000.0);
        assertEquals(859.42, calculadoraDeImpostos.calcula(funcionario), 0.0001);
    }
    
}
