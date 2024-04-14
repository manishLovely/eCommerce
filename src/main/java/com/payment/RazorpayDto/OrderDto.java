package com.payment.RazorpayDto;



public class OrderDto {

   private double amount;
    
	private String currency;
   
	private String receipt;
   
	private String notes_key_1;

	
	
	
	
	
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
