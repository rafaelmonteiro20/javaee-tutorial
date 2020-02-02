package com.hello.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ola")
public class HelloServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Hello Servlet</title></head>");

            out.println("<body>"
                + "<form method=\"get\">"
                + "<h2>Olá, meu nome é Duke. E o seu?</h2>"
                + "<input title=\"Meu nome é: \"type=\"text\" "
                + "name=\"nome\" size=\"25\">"
                + "<p></p>"
                + "<input type=\"submit\" value=\"Enviar\">"
                + "<input type=\"reset\" value=\"Reset\">"
                + "</form>");

            String nome = request.getParameter("nome");
            if (nome != null && nome.length() > 0) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resposta");
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
        
    }

}
