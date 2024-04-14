package com.jsonServer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CouponCode {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int primary_key;
	@Column(unique=true)
	private String CouponCode;
	
	private double DiscountCode;

	
	public CouponCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CouponCode(String couponCode, double discountCode) {
		super();
		CouponCode = couponCode;
		DiscountCode = discountCode;
	}



	public String getCouponCode() {
		return CouponCode;
	}

	public void setCouponCode(String couponCode) {
		CouponCode = couponCode;
	}

	public double getDiscountCode() {
		return DiscountCode;
	}

	public void setDiscountCode(double discountCode) {
		DiscountCode = discountCode;
	}
	
	
	
	
}
