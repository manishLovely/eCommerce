package com.jsonServer.validator;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsonServer.Dto.ProductCatDto;
import com.jsonServer.Dto.ProductPicDto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
@Component
public class ValidatorProgrammatically {
    @Autowired
	ProductCatValidator productCatValidator;
	
	public void validateInput(ProductCatDto productCatDto) {
		   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		   Validator validator = factory.getValidator();
		    Set<ConstraintViolation<ProductCatDto>> violations = validator.validate(productCatDto);
		    if (!violations.isEmpty()) {
		      throw new ConstraintViolationException(violations);
		    }
		  }
	
	public void validateImage(ProductPicDto productPicDto){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator  = factory.getValidator();
		Set<ConstraintViolation<ProductPicDto>> violations = validator.validate(productPicDto);
		if(!violations.isEmpty()) {
			
			throw new ConstraintViolationException(violations);
		}
		
	}
	
}
