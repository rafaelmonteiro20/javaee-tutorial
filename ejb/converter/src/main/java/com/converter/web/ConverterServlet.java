package com.converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.converter.ejb.ConverterBean;

@WebServlet(urlPatterns="/")
public class ConverterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ConverterBean converter;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	    
		PrintWriter out = response.getWriter();
	    out.println("<html lang=\"en\">");
	    out.println("<head>");
	    out.println("<title>Servlet ConverterServlet</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Servlet ConverterServlet</h1>");
		
	    try {
            String amount = request.getParameter("amount");
            if (amount != null && amount.length() > 0) {
            	BigDecimal reais = new BigDecimal(amount);
                BigDecimal dollar = converter.realToDollar(reais);

                out.println("<p>" + amount + " reais are " +
                        dollar.toPlainString() + " dollar.</p>");
            } else {
                out.println("<p>Enter a real amount to convert");
            }

        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
	}
	
}
