package com.jsonServer.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {


  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)	
  private int cartID;
  private String customerBrowserId;
  @OneToMany(mappedBy="cart",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
  private List<CartProduct> cartProduct; 
  @Column(name="cartCreationDate")
  private Date cartCreation;

  private double TotalCartValue;
  
  private String couponCode;
  
  
public Cart() {
	super();
	
}

public Cart(int cartID, String customerBrowserId, List<CartProduct> cartProduct, Date cartCreation) {
	super();
	this.cartID = cartID;
	this.customerBrowserId = customerBrowserId;
	this.cartProduct = cartProduct;
	this.cartCreation = cartCreation;
}





public double getTotalCartValue() {
	return TotalCartValue;
}

public void setTotalCartValue(double totalCartValue) {
	TotalCartValue = totalCartValue;
}

public String getCouponCode() {
	return couponCode;
}

public void setCouponCode(String couponCode) {
	this.couponCode = couponCode;
}

public int getCartID() {
	return cartID;
}

public void setCartID(int cartID) {
	this.cartID = cartID;
}

public String getCustomerBrowserId() {
	return customerBrowserId;
}

public void setCustomerBrowserId(String customerBrowserId) {
	this.customerBrowserId = customerBrowserId;
}

public List<CartProduct> getCartProduct() {
	return cartProduct;
}

public void setCartProduct(List<CartProduct> cartProduct) {
	this.cartProduct = cartProduct;
}

public Date getCartCreation() {
	return cartCreation;
}

public void setCartCreation(Date cartCreation) {
	this.cartCreation = cartCreation;
} 
  
	
	
	
	
	
}
