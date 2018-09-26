package com.rudao.advertisingplatform.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

@Configuration
public class StringConfig {

	@Bean
	public StringHttpMessageConverter stringMessageConverter() {
	    return new StringHttpMessageConverter();
	}

}
