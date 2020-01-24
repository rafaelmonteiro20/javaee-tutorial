package com.decorator.model;

public class Funcionario {

    private Cargo cargo;
    private Escolaridade escolaridade;

    public Funcionario(Cargo cargo, Escolaridade escolaridade) {
        this.cargo = cargo;
        this.escolaridade = escolaridade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }
    
    public static class FuncionarioBuilder  {

        private double salarioBase;
        private Escolaridade escolaridadeFuncionario;
        private Escolaridade escolaridadeCargo;

        public FuncionarioBuilder() {
            this.escolaridadeCargo = Escolaridade.SUPERIOR;
            this.escolaridadeFuncionario = Escolaridade.SUPERIOR;
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
        
        public Funcionario build() {
            Cargo cargo = new Cargo(salarioBase, escolaridadeCargo);
            return new Funcionario(cargo, escolaridadeFuncionario);
        }
        
    }
    
}
