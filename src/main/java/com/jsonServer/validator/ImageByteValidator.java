package com.jsonServer.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageByteValidator implements ConstraintValidator<ImageValidator,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

     if(value.length()==0) {
		return false;
	}
	else {
	
		return true;
		
	}
	
		
}
}