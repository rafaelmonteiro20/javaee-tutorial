package com.tutorial.jms;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class BrowserFila {

	public static void main(String[] args) throws Exception {
		
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Queue fila = (Queue) context.lookup("financeiro");
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		QueueBrowser browser = session.createBrowser(fila);
		
		Enumeration<?> mensagens = browser.getEnumeration();
		while (mensagens.hasMoreElements()) {
			TextMessage mensagem = (TextMessage) mensagens.nextElement();
			System.out.println(mensagem.getText());
		}
		
		session.close();
		connection.close();
		context.close();
		
	}
	
}
