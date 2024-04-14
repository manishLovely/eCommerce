package com.payment.RazorpayDto;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import com.payment.model.PaymentDetails;

public class PaymentDetailEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		PaymentDetails paymentDetails = new PaymentDetails();
		
		String str = new String(text);
		int i = 0;
		int j = 0;
		
		char c[] = str.toCharArray();
		
		 List<Integer> strList = new ArrayList<>();   
			for(char c1:c) {
				
		 if(c1==':'||c1=='}') {
			 
			strList.add(j,i); 
			 j++;
		 }
			
			i++;	
			}
		
		//      strList;
		      
		      List<String> stringList = new ArrayList<>();
			    
			    int p = 0;
			    
			    int start = 0;
			    int end = 0;
			    
			   
			    
			 for(int c2:strList) {
				
				if(p%2==0) {
				start = c2;
				}
				
				if(p%2!=0) {
					end = c2;
					String s2 =  str.substring(start+1,end);	
					
					stringList.add(s2);
					
			
				}
				
			     
			    	
				
				 p++;
				
			    }	      
		
		
			 paymentDetails.setOrderAmount(Double.valueOf(stringList.get(2)));
			 paymentDetails.setOrderId(stringList.get(1));
			 paymentDetails.setPaymentId(stringList.get(0));
		
			 List<PaymentDetails>  paymentDetailList = new ArrayList<>();
	      
			 paymentDetailList.add(paymentDetails);
			 
			 setValue(paymentDetailList);
	}

   



}
