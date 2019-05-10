package com.learn.camel.activemq;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:input_box?noop=true")
		.to("jms:queue:messageQueue");
	}

}