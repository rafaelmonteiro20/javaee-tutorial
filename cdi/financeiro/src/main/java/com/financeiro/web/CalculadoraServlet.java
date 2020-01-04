package com.financeiro.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.financeiro.model.Funcionario;
import com.financeiro.model.builder.FuncionarioBuilder;
import com.financeiro.service.CalculadoraDeImpostos;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private CalculadoraDeImpostos calculadoraDeImposto;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double salario = Double.parseDouble(request.getParameter("salario"));

        Funcionario funcionario = new FuncionarioBuilder()
                .comSalarioBaseDe(salario)
                .build();

        double imposto = calculadoraDeImposto.calcula(funcionario);
        response.getOutputStream().print(String.format("Salario base: R$ %.2f\n" +
                "Imposto devido: R$ %.2f", salario, imposto));
    }

}
