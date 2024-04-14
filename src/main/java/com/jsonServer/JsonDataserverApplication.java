package com.jsonServer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class JsonDataserverApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
		
	public static void main(String[] args) {
		SpringApplication.run(JsonDataserverApplication.class, args);
	}

	
		
	}
	
	
	

