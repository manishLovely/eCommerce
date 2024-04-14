package com.jsonServer.corsConfigure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    
	@Value("${cors.url1}")
	private String url1;
	@Value("${cors.url2}")
	private String url2;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		
		registry.addMapping("/dataServer/**")
			.allowedOrigins(url2,url1)
			.allowedMethods("POST","GET")
	//		.allowedHeaders("http://localhost:3000","http://localhost:3001")
			
			.allowCredentials(true).maxAge(3600);

		
        
		
	}

}
