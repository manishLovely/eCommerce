package com.jsonServer.Dto;

public class UpdateProdCatDto {

	private String prodCategoryId;
	
	private String prodCategory;

	public UpdateProdCatDto() {
		super();
		
	}

	public UpdateProdCatDto(String prodCategoryId, String prodCategory) {
		super();
		this.prodCategoryId = prodCategoryId;
		this.prodCategory = prodCategory;
	}

	public String getProdCategoryId() {
		return prodCategoryId;
	}

	public void setProdCategoryId(String prodCategoryId) {
		this.prodCategoryId = prodCategoryId;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	
	
	
	
}
