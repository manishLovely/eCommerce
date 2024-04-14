package com.jsonServer.Dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDataDto {
	
      private String    prodCategoryId;
      private String prodCategory;
     
      private String   prodId;
      private String prodTitle;
      private int    prodQuantity;
    
      private String    rateProd;
      private String    totalRate;
      private int       cutPrice;
      private int    salePrice;
      private int    offer;
      
     
        
    public ProductDataDto() {
		super();
		
	}
    
    
    
    
    
	public ProductDataDto(String prodCategoryId, String prodCategory, String prodId, String prodTitle, int prodQuantity,
			String rateProd, String totalRate, int cutPrice, int salePrice, int offer) {
		super();
		this.prodCategoryId = prodCategoryId;
		this.prodCategory = prodCategory;
		this.prodId = prodId;
		this.prodTitle = prodTitle;
		this.prodQuantity = prodQuantity;
		this.rateProd = rateProd;
		this.totalRate = totalRate;
		this.cutPrice = cutPrice;
		this.salePrice = salePrice;
		this.offer = offer;
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
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdTitle() {
		return prodTitle;
	}
	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}
	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public String getRateProd() {
		return rateProd;
	}
	public void setRateProd(String rateProd) {
		this.rateProd = rateProd;
	}
	public String getTotalRate() {
		return totalRate;
	}
	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}
	public int getCutPrice() {
		return cutPrice;
	}
	public void setCutPrice(int cutPrice) {
		this.cutPrice = cutPrice;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
      
      
	
      
	

}
