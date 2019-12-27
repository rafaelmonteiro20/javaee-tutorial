package com.financeiro.model;

public class Cargo {

    private double salarioBase;
    private Escolaridade escolaridadeDesejada;

    public Cargo(double salarioBase, Escolaridade escolaridadeDesejada) {
        this.salarioBase = salarioBase;
        this.escolaridadeDesejada = escolaridadeDesejada;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Escolaridade getEscolaridadeDesejada() {
        return escolaridadeDesejada;
    }

}
