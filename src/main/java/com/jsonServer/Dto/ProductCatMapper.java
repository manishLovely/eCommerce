package com.jsonServer.Dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.stereotype.Component;

@Component
public class ProductCatMapper {

	 private String prodCategoryId;
	   private String prodCategory;
	  
	 
	   private String   prodId;
	   private String prodTitle;
	   private int     prodQuantity;
	 
	   private String    rateProd;
	   private String    totalRate;
	   private int       cutPrice;
	   private int    salePrice;
	   private int    offer;
	   
	      
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
	   
	public MutablePropertyValues IterableMapper() {
		
		 MutablePropertyValues jsonStrMap = new MutablePropertyValues();
		
		jsonStrMap.add("prodCategoryId",prodCategoryId);
		jsonStrMap.add("prodCategory",prodCategory);
		jsonStrMap.add("prodId",prodId);
		jsonStrMap.add("prodTitle",prodTitle);
		jsonStrMap.add("prodQuantity",prodQuantity);
		jsonStrMap.add("rateProd",rateProd);
		jsonStrMap.add("totalRate",totalRate);
		jsonStrMap.add("cutPrice",cutPrice);
		jsonStrMap.add("salePrice",salePrice);
		jsonStrMap.add("offer",offer);
		
		
		
		return jsonStrMap;
	}   
	
	
	
	
}
