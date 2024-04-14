package com.jsonServer.exceptionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import jakarta.validation.ConstraintViolationException;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private String error;
	
	char[] target;
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> exceptionHandler(ConstraintViolationException e){
	    
		boolean sbStarter = false;
		//Map<String,String> exceptionResponse = new HashMap<>();
		// List<String> rs = new ArrayList<>();
		 StringBuffer sb = new StringBuffer(100);
		 String st ;
		 error = e.getMessage();
		 System.out.println(error);
		char[] errArray = error.toCharArray();
	outer:for(char a: errArray) {
		int i = 0;
		System.out.println(a);
			if(a==':') {
				sbStarter = true;
				continue outer;
			}
			if(sbStarter) {
				
				
				sb.insert(i, a);
				
				
				
			}
			if(a==',') {
				sbStarter = false;
				 st = new String(sb);
				
				continue outer;
			}
			
			
		}
	   
	
		
		//exceptionResponse.put("error",error);
	/*	
		e.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			exceptionResponse.put(fieldName, message);
			
			
		});*/
	 sb.reverse();
	
		return ResponseEntity.badRequest().body(sb.toString());
	}
	@ExceptionHandler(com.jsonServer.exception.DuplicateException.class)
	public ResponseEntity<String> DuplicateException(com.jsonServer.exception.DuplicateException e){
		
		String str = e.toString();
		
		
		
		
		return ResponseEntity.badRequest().body(str);
	}
	
	@ExceptionHandler(MissingServletRequestPartException.class)
	public ResponseEntity<String> picNotPresent(MissingServletRequestPartException e){
		
		String str1 = "Product image file not present";
		
		return ResponseEntity.badRequest().header("Access-Control-Allow-Origin","http://localhost:3000").body(str1);
	}

}
