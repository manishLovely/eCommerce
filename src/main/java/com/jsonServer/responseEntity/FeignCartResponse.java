package com.jsonServer.responseEntity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jsonServer.model.CartProduct;

@Component
public class FeignCartResponse {

	private List<CartProduct> cartProduct;
	
	private double totalCartValue;
	private String couponCode;
	private boolean isCoupon;
	private double couponValue;
	
	
	
	public double getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(double couponValue) {
		this.couponValue = couponValue;
	}
	public boolean isCoupon() {
		return isCoupon;
	}
	public void setCoupon(boolean isCoupon) {
		this.isCoupon = isCoupon;
	}
	public FeignCartResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<CartProduct> getCartProduct() {
		return cartProduct;
	}
	public void setCartProduct(List<CartProduct> cartProduct) {
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
	
	
	
	
}
