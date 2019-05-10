package com.learn.camel.activemq;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQRouteObject extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("direct:start")
		.to("jms:queue:messageQueue");
	}

}