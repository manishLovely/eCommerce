package com.payment.RazorpayDto;

public class PaymentDetailsDto {

	private String paymentId;
	private String orderId;
	private double orderAmount;
	
	
	
	public PaymentDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
	
}
