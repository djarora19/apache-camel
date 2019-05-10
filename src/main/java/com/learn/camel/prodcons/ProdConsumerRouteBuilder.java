package com.learn.camel.prodcons;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ProdConsumerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("direct:start")
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				System.out.println("Running from processor !");
				
				String message = exchange.getIn().getBody(String.class);
				message = message.toUpperCase();
				
				exchange.getOut().setBody(message);
			}
		})
		.to("seda:end");
		
	}

}