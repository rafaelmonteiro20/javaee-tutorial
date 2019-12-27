package com.financeiro.model;

public class Funcionario {

    private Cargo cargo;
    private Escolaridade escolaridade;
    private int anoAdmissao;

    public Funcionario(Cargo cargo, Escolaridade escolaridade, int anoAdmissao) {
        this.cargo = cargo;
        this.escolaridade = escolaridade;
        this.anoAdmissao = anoAdmissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public int getAnoAdmissao() {
        return anoAdmissao;
    }
    
}
