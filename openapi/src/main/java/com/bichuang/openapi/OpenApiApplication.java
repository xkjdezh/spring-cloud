package com.bichuang.openapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
@ComponentScan({"com.bichuang.openapi"})
@MapperScan({"com.bichuang.openapi.repository.mapper"})
public class OpenApiApplication   extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OpenApiApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(OpenApiApplication.class, args);
	}
	


}
