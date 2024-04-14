package com.payment.feignClient;

import java.util.List;



public class CartDataResponse {

	
  private List<CartProducts> cartProduct;
   
  private double  totalCartValue;
  
  private String couponCode;

  private boolean isCoupon;
  
  private double couponValue;
  
  
public CartDataResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public List<CartProducts> getCartProduct() {
	return cartProduct;
}

public void setCartProduct(List<CartProducts> cartProduct) {
	this.cartProduct = cartProduct;
}

public double getTotalCartValue() {
	return totalCartValue;
}

public void setTotalCartValue(double totalCartValue) {
	this.totalCartValue = totalCartValue;
}

public String getCouponCode() {
	return couponCode;
}

public void setCouponCode(String couponCode) {
	this.couponCode = couponCode;
}

public boolean isCoupon() {
	return isCoupon;
}

public void setCoupon(boolean isCoupon) {
	this.isCoupon = isCoupon;
}

public double getCouponValue() {
	return couponValue;
}

public void setCouponValue(double couponValue) {
	this.couponValue = couponValue;
}
  



	
}
