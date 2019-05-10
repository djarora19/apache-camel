package com.learn.camel.prodcons;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelProducerConsumer {

	public static void main(String[] args) throws Exception {
		
		CamelContext camelContext = new DefaultCamelContext();

		ProdConsumerRouteBuilder route = new ProdConsumerRouteBuilder();
		camelContext.addRoutes(route);
		
		camelContext.start();
		
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello Camel from Producer !");
		
		ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
		String receivedMessage = consumerTemplate.receiveBody("seda:end", String.class);
		
		System.out.println(receivedMessage);

		camelContext.stop();

	}

}