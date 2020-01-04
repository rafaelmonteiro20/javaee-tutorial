package com.financeiro.model.builder;

import java.time.Year;

import com.financeiro.model.Cargo;
import com.financeiro.model.Escolaridade;
import com.financeiro.model.Funcionario;

public class FuncionarioBuilder {

    private int anoAdmissao;
    private Escolaridade escolaridadeFuncionario;
    private Escolaridade escolaridadeCargo;
    private double salarioBase;

    public FuncionarioBuilder() {
        this.escolaridadeCargo = Escolaridade.SUPERIOR;
        this.escolaridadeFuncionario = Escolaridade.SUPERIOR;
        this.anoAdmissao = Year.now().getValue();
    }

    public FuncionarioBuilder comSalarioBaseDe(double salarioBase) {
        this.salarioBase = salarioBase;
        return this;
    }
    
    public FuncionarioBuilder comEscolaridade(Escolaridade escolaridade) {
        this.escolaridadeFuncionario = escolaridade;
        return this;
    }

    public FuncionarioBuilder comEscolaridadeDesejada(Escolaridade escolaridade) {
        this.escolaridadeCargo = escolaridade;
        return this;
    }
    
    public FuncionarioBuilder admitidoEm(int ano) {
        this.anoAdmissao = ano;
        return this;
    }

    public Funcionario build() {
        Cargo cargo = new Cargo(salarioBase, escolaridadeCargo);
        return new Funcionario(cargo, escolaridadeFuncionario, anoAdmissao);
    }

}
