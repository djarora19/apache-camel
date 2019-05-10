package com.learn.camel.beancomp;

import org.apache.camel.builder.RouteBuilder;

public class CamelBeanRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("direct:start")
		.bean(MessageService.class, "displayMessage");
		//.to("bean:messageService?method=displayMessage");
	}
}