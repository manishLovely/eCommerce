package com.payment.RazorpayDto;

import org.springframework.stereotype.Component;

@Component
public class OrderResponse {

	private String order_id;
	
	private double order_Amount;

	
	
	
	public OrderResponse() {
		super();
		
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public double getOrder_Amount() {
		return order_Amount;
	}

	public void setOrder_Amount(double order_Amount) {
		this.order_Amount = order_Amount;
	}
	
	
	
	
}
