package com.tutorial.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class ProdutorTopico {

	public static void main(String[] args) throws Exception {
		
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Topic topico = (Topic) context.lookup("venda");
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(topico);
		
		TextMessage message = session.createTextMessage("<produto><id>" + 123 + "</id></produto>");
		producer.send(message);
		
		session.close();
		connection.close();
		context.close();
		
	}
	
}
