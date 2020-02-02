package com.even.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

import com.even.validator.Par;

public class Funcionario {

    @NotBlank
    private String nome;
    
    @DecimalMin("100.0")
    private BigDecimal salario;
    
    @Par
    private Integer matricula;

    public Funcionario(String nome, BigDecimal salario, Integer matricula) {
        this.nome = nome;
        this.salario = salario;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Integer getMatricula() {
        return matricula;
    }
    
}
