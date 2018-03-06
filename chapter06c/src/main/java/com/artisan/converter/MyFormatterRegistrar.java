package com.artisan.converter;


import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class MyFormatterRegistrar implements FormatterRegistrar {
	
	private String dataPattern;
	
	public MyFormatterRegistrar(String dataPattern) {
		super();
		this.dataPattern = dataPattern;
	}


	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.addFormatter(new MyFormatter(dataPattern));
		// u can registry more formatters here 
	}

	
}
