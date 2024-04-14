package com.jsonServer.cloudinary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
	
	@Bean
	public Cloudinary getClodinary() {
		
		Map config = new HashMap();
		
		config.put("cloud_name","dpe2ar6gp");
		config.put("api_key","983276532989191");
		config.put("api_secret","NKiueBWzP_MvUbRK-92wZAKz3JE");
		config.put("secure",true);
		
		
		return new Cloudinary(config);
		
	}
	
	

}
