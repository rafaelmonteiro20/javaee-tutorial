package com.validacao.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.validacao.model.grupo.InformacaoContato;
import com.validacao.model.grupo.InformacaoEndereco;

public class Funcionario {

    @NotBlank
    private String nome;

    @NotNull
    @DecimalMin("1000.0")
    private BigDecimal salario;

    @NotBlank(groups = InformacaoContato.class)
    private String telefone;

    @NotBlank(groups = InformacaoEndereco.class)
    private String endereco;

    @NotBlank(groups = InformacaoEndereco.class)
    private String cidade;

    public Funcionario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public static class FuncionarioBuilder {
        
        Funcionario funcionario = new Funcionario();
        
        public FuncionarioBuilder comNome(String nome) {
            funcionario.nome = nome;
            return this;
        }
        
        public Funcionario build() {
            return funcionario;
        }
        
    }

}
