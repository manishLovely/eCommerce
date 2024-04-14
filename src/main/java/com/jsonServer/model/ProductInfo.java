package com.jsonServer.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productItem")
@IdClass(ProdIds.class)
public class ProductInfo {
	
     
	@Id
	@Column(unique=true)
    private String    prodId;
    private String prodTitle;
    private int    prodQuantity;
    private String   rateProd;
    private String    totalRate;
    private float    cutPrice;
    private float   salePrice;
    private int    offer;
    
   
  
	private String prodPicUrl;
    
	@ManyToOne(fetch=FetchType.EAGER)
	private ProdCategory prodCategory;

	
	
	
	
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo( String prodId, String prodTitle, int prodQuantity, String rateProd,
			String totalRate, Long cutPrice, Long salePrice, int offer, String prodPicUrl, ProdCategory prodCategory) {
		super();
		
		this.prodId = prodId;
		this.prodTitle = prodTitle;
		this.prodQuantity = prodQuantity;
		this.rateProd = rateProd;
		this.totalRate = totalRate;
		this.cutPrice = cutPrice;
		this.salePrice = salePrice;
		this.offer = offer;
		this.prodPicUrl = prodPicUrl;
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

	public float getCutPrice() {
		return cutPrice;
	}

	public void setCutPrice(float cutPrice) {
		this.cutPrice = cutPrice;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public String getProdPicUrl() {
		return prodPicUrl;
	}

	public void setProdPicUrl(String prodPicUrl) {
		this.prodPicUrl = prodPicUrl;
	}

	public ProdCategory getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(ProdCategory prodCategory) {
		this.prodCategory = prodCategory;
	}
   
    

	
		
	
}
