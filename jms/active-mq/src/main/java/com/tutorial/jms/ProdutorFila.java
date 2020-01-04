package com.tutorial.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class ProdutorFila {

	public static void main(String[] args) throws Exception {
		
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Destination fila = (Destination) context.lookup("financeiro");
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(fila);
		
		for (int i = 1; i <= 10; i++) {
			TextMessage message = session.createTextMessage("<produto><id>" + i + "</id></produto>");
			producer.send(message);
		}

		session.close();
		connection.close();
		context.close();
		
	}
	
}
