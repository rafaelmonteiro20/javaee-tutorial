package com.confirmacao.model;

import com.confirmacao.validator.Confirmacao;


@Confirmacao(campo = "email", campoCorrespondente = "confirmacaoEmail", message = "Emails não correspondem.")
@Confirmacao(campo = "senha", campoCorrespondente = "confirmacaoSenha", message = "Senhas não correspondem.")
public class Usuario {

    private String nome;
    private String email;
    private String confirmacaoEmail;
    private String senha;
    private String confirmacaoSenha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmacaoEmail() {
        return confirmacaoEmail;
    }

    public void setConfirmacaoEmail(String confirmacaoEmail) {
        this.confirmacaoEmail = confirmacaoEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

}
