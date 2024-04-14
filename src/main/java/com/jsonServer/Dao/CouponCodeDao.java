package com.jsonServer.Dao;

import com.jsonServer.exception.DuplicateException;
import com.jsonServer.model.CouponCode;

public interface CouponCodeDao {

	public void SaveCouponCode(CouponCode couponCode) throws DuplicateException ;
	
	public CouponCode getCouponCode(String coupon);
}
