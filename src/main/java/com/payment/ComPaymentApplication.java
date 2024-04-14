package com.payment;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
public class ComPaymentApplication {

	@Bean	
	public ModelMapper modelMapper() {
	
	return new ModelMapper();
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ComPaymentApplication.class, args);
	}

	

	
}
