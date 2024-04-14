package com.payment.RazorpayDto;

import java.beans.PropertyEditorSupport;

public class DoubleEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Double value = Double.valueOf(text);
		
		Double doubleValue = value*100;
		
			System.out.println("custom property editor");
		 setValue(doubleValue);
	}

	

	
	
	
}
