package com.learn.camel.hellocamel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;


public class HelloCamel {

	public static void main(String[] args) throws Exception {
		
		CamelContext camelContext = new DefaultCamelContext();
		
		HelloWorldRoute route = new HelloWorldRoute();
		
		camelContext.addRoutes(route);
		
		camelContext.start();
		
		camelContext.stop();
	}

}