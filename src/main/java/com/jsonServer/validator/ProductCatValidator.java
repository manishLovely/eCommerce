package com.jsonServer.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jsonServer.Dto.ProductCatDto;
import com.jsonServer.Dto.ProductDataDto;

@Component
public class ProductCatValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ProductCatDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"prodCategoryId","prodCategoryId.empty","product id is null");
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"prodId","prodId.empty","product id is null");
		
	}

}
