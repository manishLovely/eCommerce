package com.payment.RazorpayDto;


import java.util.List;

import com.payment.model.PaymentDetails;




public class PaymentDto {
    
	private double amount1;
    
	private String currency;
   
	private String receipt;
   
	private String notes_key_1;
	
	private String email;
	
	private String first_name;
	
	private String last_name;
	
	private String address;
	
	private String city;
	
	private String phone_number;
	
	private boolean news_offers;
	
	private List<PaymentDetails> paymentDetails;
	
	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	


	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetails;
	}





	public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}





	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	

	




	public String getPhone_number() {
		return phone_number;
	}





	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}





	public boolean isNews_offers() {
		return news_offers;
	}





	public void setNews_offers(boolean news_offers) {
		this.news_offers = news_offers;
	}





	public double getAmount() {
		return amount1;
	}
	public void setAmount(double amount) {
		this.amount1 = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getNotes_key_1() {
		return notes_key_1;
	}
	public void setNotes_key_1(String notes_key_1) {
		this.notes_key_1 = notes_key_1;
	}
	
	
	
	
}
