package com.learn.camel.classcomp;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelClassComp {

	public static void main(String[] args) throws Exception {
		
		CamelContext camelContext = new DefaultCamelContext();
		
		CamelClassRouteBuilder routeBuilder = new CamelClassRouteBuilder();
		camelContext.addRoutes(routeBuilder);
		
		camelContext.start();
		
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello There!");

	}

}
