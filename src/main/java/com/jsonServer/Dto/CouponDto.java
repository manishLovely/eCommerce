package com.jsonServer.Dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Component
public class CouponDto {
	
	@NotEmpty
	private String  couponCode;
	@Min(value=0,message="coupon discount can't be less than 1")
	@Max(value=2000,message="coupon discount can't be greater than 2000")
	private double couponDiscount;

	
	public CouponDto() {
		super();
		
	}
	
	

	public CouponDto(String couponCode, double couponDiscount) {
		super();
		this.couponCode = couponCode;
		this.couponDiscount = couponDiscount;
	}



	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public double getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}
	
	

}
