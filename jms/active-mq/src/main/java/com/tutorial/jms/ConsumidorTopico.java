package com.tutorial.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class ConsumidorTopico {

	public static void main(String[] args) throws Exception {
		
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.setClientID("estoque");
		connection.start();
		
		Topic topico = (Topic) context.lookup("venda");
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");
		
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					try {
						TextMessage texto = (TextMessage) message;
						System.out.println(texto.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		scanner.close();
		session.close();
		connection.close();
		context.close();
		
	}
	
}
