package com.learn.camel.classcomp;

import org.apache.camel.builder.RouteBuilder;

public class CamelClassRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("direct:start")
		.to("class:com.learn.camel.classcomp.MessageService?method=displayMessage");
	}
}