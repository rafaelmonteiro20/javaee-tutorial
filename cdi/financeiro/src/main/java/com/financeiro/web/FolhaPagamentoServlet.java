package com.financeiro.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.financeiro.model.Folha;
import com.financeiro.model.Funcionario;
import com.financeiro.model.PlanoDeCargos;
import com.financeiro.model.builder.FuncionarioBuilder;
import com.financeiro.service.CalculadoraFolhaPagamento;
import com.financeiro.service.annotation.Simulador;

@WebServlet("/folha-pagamento")
public class FolhaPagamentoServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject 
    @Simulador(planoDeCargos = PlanoDeCargos.VERSAO_2020)
    private CalculadoraFolhaPagamento calculadoraFolhaPagamento;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        FuncionarioBuilder builder = new FuncionarioBuilder();
        Funcionario f1 = builder.comSalarioBaseDe(1000.0).build();
        Funcionario f2 = builder.comSalarioBaseDe(2000.0).build();
        Funcionario f3 = builder.comSalarioBaseDe(3000.0).build();
        
        List<Funcionario> funcionarios = Arrays.asList(f1, f2, f3);
        Folha folhaCalculada = calculadoraFolhaPagamento.calculaFolha(funcionarios);
        
        ServletOutputStream out = response.getOutputStream();
        out.print(String.format("Total da Folha: R$ %.2f\n", folhaCalculada.getTotal()));
        out.print("Simulador utilizado: " + calculadoraFolhaPagamento.getClass().getSimpleName());
        
    }
    
}
