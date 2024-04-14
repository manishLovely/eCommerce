package com.jsonServer.exception;

public class DuplicateException extends Exception {

	
	
	String exceptionMessage;
	
	public DuplicateException() {
		super();
	}
	
   public DuplicateException(String exceptionMessage) {
	   super(exceptionMessage);
	   this.exceptionMessage = exceptionMessage;
   }
	
	public String toString() {
		
		return exceptionMessage;
	}
	
	
	
}
