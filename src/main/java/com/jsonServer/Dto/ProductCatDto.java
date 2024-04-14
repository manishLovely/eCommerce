package com.jsonServer.Dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;



@Component
public class ProductCatDto {
   @NotEmpty(message="prodCategory can't be null")
   private String prodCategoryId;
   @NotEmpty(message="prod category can't be empty")
   private String prodCategory;
  
   @NotEmpty(message="prod category can't be empty")
   private String   prodId;
   @NotEmpty(message="prod category can't be empty")
   private String prodTitle;
   @Min(value =1,message="can't be smaller than 1 ")
   @Max(value=60, message="can't be greater than 60")
   private int     prodQuantity;
 
   private String    rateProd;
   private String    totalRate;
   private Long       cutPrice;
   private Long    salePrice;
   private int    offer;
   
   
   
   
   
   
   
public ProductCatDto() {
	super();
	
}
public ProductCatDto(String prodCategoryId, String prodCategory, String prodId, String prodTitle, int prodQuantity,
		String rateProd, String totalRate, Long cutPrice, Long salePrice, int offer) {
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
public Long getCutPrice() {
	return cutPrice;
}
public void setCutPrice(Long cutPrice) {
	this.cutPrice = cutPrice;
}
public Long getSalePrice() {
	return salePrice;
}
public void setSalePrice(Long salePrice) {
	this.salePrice = salePrice;
}
public int getOffer() {
	return offer;
}
public void setOffer(int offer) {
	this.offer = offer;
}
@Override
public String toString() {
	return "ProductCatDto [prodCategoryId=" + prodCategoryId + ", prodCategory=" + prodCategory + ", prodId=" + prodId
			+ ", prodTitle=" + prodTitle + ", prodQuantity=" + prodQuantity + ", rateProd=" + rateProd + ", totalRate="
			+ totalRate + ", cutPrice=" + cutPrice + ", salePrice=" + salePrice + ", offer=" + offer + "]";
}
   
   

	
	
	
}
