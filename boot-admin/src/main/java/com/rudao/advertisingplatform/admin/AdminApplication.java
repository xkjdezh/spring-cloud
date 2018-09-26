package com.rudao.advertisingplatform.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;


@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class AdminApplication  {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

/*	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AdminApplication.class);
	}*/
}