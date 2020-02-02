package com.even.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import com.even.model.Funcionario;

public class FuncionarioServiceTest {

    private Validator validador;
    
    public FuncionarioServiceTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validador = factory.getValidator();
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void validaNumeroPar() {
        Funcionario funcionario = new Funcionario("Rafael", new BigDecimal("1500.0"), 10001);
        Set<ConstraintViolation<Funcionario>> erros = validador.validate(funcionario);
        ConstraintViolation<Funcionario>[] array = erros.toArray(new ConstraintViolation[0]);
        assertEquals("Número deve ser par", array[0].getMessage());
    }

    @Test
    public void funcionarioValido() {
        Funcionario funcionario = new Funcionario("Rafael", new BigDecimal("2500.0"), 200);
        Set<ConstraintViolation<Funcionario>> erros = validador.validate(funcionario);
        assertTrue(erros.isEmpty());
    }
    
}
