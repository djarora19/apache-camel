package com.learn.camel.filecopy;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:input_box?noop=true")
		.to("file:output_box");
	}

}