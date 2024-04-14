package com.jsonServer.Dto;

import org.springframework.stereotype.Component;

import com.jsonServer.validator.ImageValidator;



@Component
public class ProductPicDto {
	
	 @ImageValidator(message="select an product image")	 
	 private String prodPicUrl;

	public String getProdPicUrl() {
		return prodPicUrl;
	}

	public void setProdPicUrl(String prodPicUrl) {
		this.prodPicUrl = prodPicUrl;
	}

	
   
}
