package com.jsonServer.Dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
@Component
public class ProdIdDto {
   
	@NotEmpty(message="error with cart")
	private String prodId;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	
}
