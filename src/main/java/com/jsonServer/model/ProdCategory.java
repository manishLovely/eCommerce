package com.jsonServer.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="prodCategory")
public class ProdCategory {
    
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int prodCategoryKey;
     @Column(unique=true)
     private String    prodCategoryId;

	 private String prodCategory;
	 @OneToMany(mappedBy="prodCategory",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 private List<ProductInfo> productInfo;
	 
	 
	
	 
	 
	 
	 
	public ProdCategory() {
		super();
		
	}

	public ProdCategory(int prodCategoryKey, String prodCategoryId, String prodCategory,
			List<ProductInfo> productInfo) {
		super();
		this.prodCategoryKey = prodCategoryKey;
		this.prodCategoryId = prodCategoryId;
		this.prodCategory = prodCategory;
		this.productInfo = productInfo;
	}
	
	
	
	
	
	public int getProdCategoryKey() {
		return prodCategoryKey;
	}

	public void setProdCategoryKey(int prodCategoryKey) {
		this.prodCategoryKey = prodCategoryKey;
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
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	 
	 
	 
	
	 
	 
	
	
	
}
