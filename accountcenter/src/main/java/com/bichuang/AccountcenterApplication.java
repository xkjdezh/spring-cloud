package com.bichuang;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com.bichuang" })
@MapperScan("com/bichuang/repository/mapper")
public class AccountcenterApplication extends SpringBootServletInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(AccountcenterApplication.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {   
		logger.info("start account center............");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AccountcenterApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountcenterApplication.class, args);
	}
}
