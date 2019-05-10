package com.learn.camel.activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelActiveMQConsumer {

	public static void main(String[] args) throws Exception {

		CamelContext camelContext = new DefaultCamelContext();

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		ActiveMQRouteConsumer activeMQRoute = new ActiveMQRouteConsumer();
		camelContext.addRoutes(activeMQRoute);
		
		camelContext.start();
		
		ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
		String messageReceived = consumerTemplate.receiveBody("seda:end", String.class);
		
		System.out.println(messageReceived);
	}

}
