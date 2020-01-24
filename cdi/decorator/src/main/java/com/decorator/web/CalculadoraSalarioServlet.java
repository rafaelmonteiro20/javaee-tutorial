package com.decorator.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decorator.model.Funcionario;
import com.decorator.service.CalculadoraDeSalario;

@WebServlet("/calculadora")
public class CalculadoraSalarioServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private CalculadoraDeSalario calculadoraDeSalario;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double salario = Double.parseDouble(request.getParameter("salario"));

        Funcionario funcionario = new Funcionario.FuncionarioBuilder()
                .comSalarioBaseDe(salario)
                .build();

        double imposto = calculadoraDeSalario.calcula(funcionario);
        response.getOutputStream().print(String.format("Salário base: R$ %.2f\n" +
                "Salário calculado: R$ %.2f", salario, imposto));
    }

}
