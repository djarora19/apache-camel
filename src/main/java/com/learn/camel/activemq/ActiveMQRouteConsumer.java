package com.learn.camel.activemq;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQRouteConsumer extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("jms:queue:messageQueue")
		.to("seda:end");
	}

}