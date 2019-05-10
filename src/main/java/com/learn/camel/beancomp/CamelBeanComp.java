package com.learn.camel.beancomp;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelBeanComp {

	public static void main(String[] args) throws Exception {
		
		/*MessageService messageService = new MessageService();
		
		Map map = new HashMap();
		map.put("messageService", messageService);
		
		SimpleRegistry registry = new SimpleRegistry();
		registry.put("messageService", map);
		
		CamelContext camelContext = new DefaultCamelContext(registry);*/

		
		CamelContext camelContext = new DefaultCamelContext();
		
		CamelBeanRouteBuilder routeBuilder = new CamelBeanRouteBuilder();
		camelContext.addRoutes(routeBuilder);
		
		camelContext.start();
		
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello There!");

	}

}
