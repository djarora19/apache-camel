package com.learn.camel.activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelActiveMQ {

	public static void main(String[] args) throws Exception {

		CamelContext camelContext = new DefaultCamelContext();

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		ActiveMQRoute activeMQRoute = new ActiveMQRoute();
		camelContext.addRoutes(activeMQRoute);
		
		while(true)
			camelContext.start();
	}

}
