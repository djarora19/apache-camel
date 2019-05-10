package com.learn.camel.filecopy;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelFileCopy {
	
	public static void main(String[] args) throws Exception {
		
		CamelContext camelContext = new DefaultCamelContext();
		
		FileCopyRoute fileCopyRoute = new FileCopyRoute();
		
		camelContext.addRoutes(fileCopyRoute);
		
		while(true)
			camelContext.start();
	}

}