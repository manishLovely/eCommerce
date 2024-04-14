package com.jsonServer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity

public class CartProduct {
  	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="primary_Key")
    private int cartProduct_PK;
    
	
    private String prodId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private String imageUrl;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fKcartId")
    private Cart cart;
	
	
	
	
	public CartProduct() {
		super();
		
	}
	public CartProduct(String prodId, String productName, double productPrice, int productQuantity,
			String imageUrl, Cart cart) {
		super();
		
		this.prodId = prodId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.imageUrl = imageUrl;
		this.cart = cart;
	}
	
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String productId) {
		this.prodId = productId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
