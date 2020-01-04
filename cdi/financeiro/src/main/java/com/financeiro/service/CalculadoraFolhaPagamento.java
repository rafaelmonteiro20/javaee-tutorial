package com.financeiro.service;

import java.util.List;

import com.financeiro.model.Folha;
import com.financeiro.model.Funcionario;

public interface CalculadoraFolhaPagamento {

    Folha calculaFolha(List<Funcionario> funcionarios);
    
}
