package com.agenda.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.model.Contato;

@WebServlet("/contatos")
public class ContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String data = req.getParameter("dataNascimento");
		
		Date dataNascimento = null;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dataNascimento = format.parse(data);
		} catch (ParseException e) {
			out.print("Erro ao converter a data");
			return;
		}
		
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " salvo com sucesso!");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
