package com.payment.orderCreation;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Component
public class RazorOrder {

	RazorpayClient razorpay = null;
	
	public  RazorOrder() throws RazorpayException {
		
		razorpay = new RazorpayClient("rzp_test_3IaMK3Pi2SwEju", "Y0glbR1yTLNuqL3Lk3hOzCZN");	
		
	}
	
	
	public Order OrderMethod(double amount,String currency,String receipt,String notes_key_1) throws Exception {
		
		try {
		

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount",amount);
		orderRequest.put("currency",currency);
		orderRequest.put("receipt", receipt);
		JSONObject notes = new JSONObject();
		notes.put("notes_key_1",notes_key_1);
		orderRequest.put("notes",notes);

		Order order = razorpay.orders.create(orderRequest);
		
		System.out.println(order.toJson().get("id"));
		
	//	return order.toJson().get("id");
		
		return order;
		
		}catch(RazorpayException e) {
			
			System.out.println(e.getMessage());
		    throw new Exception(e.getMessage());
		}
		
	}
	

	public void paymentMethod() {
		
		JSONObject orderRequest = new JSONObject();
		
		orderRequest.put("amount",1000);
		orderRequest.put("currency","INR");
		
		
	}
	
	
	
	
}
