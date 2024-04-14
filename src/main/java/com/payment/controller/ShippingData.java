package com.payment.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.RazorpayDto.DoubleEditor;
import com.payment.RazorpayDto.OrderDto;
import com.payment.RazorpayDto.OrderResponse;
import com.payment.RazorpayDto.PaymentDetailEditor;
import com.payment.RazorpayDto.PaymentDto;
import com.payment.Repository.CustomerInforRepo;
import com.payment.customerAddressDto.AddressInfo;
import com.payment.dao.CustomerInforDao;
import com.payment.dao.PaymentDetailsDao;
import com.payment.feignClient.CartDataResponse;
import com.payment.feignClient.CartDeleteResponse;
import com.payment.feignClient.EcommerceServiceRes;
import com.payment.model.CustomerInfor;
import com.payment.model.PaymentDetails;
import com.payment.orderCreation.RazorOrder;
import com.razorpay.Order;

import jakarta.validation.Valid;

@RestController
public class ShippingData {
 
@Autowired	
private RazorOrder razorOrder;	

@Autowired
private EcommerceServiceRes ecommerceServiceRes;

@Autowired
ModelMapper modelMapper;


@Autowired
CustomerInforDao customerInforDao;

@Autowired
PaymentDetailsDao paymentDetailsDao;

@Autowired
OrderResponse orderResponse;

@CrossOrigin(origins="http://localhost:3000/",allowCredentials="true")	
@PostMapping(path="/shippingData")	
	public ResponseEntity<CustomerInfor> dataMethod(@Valid @RequestBody AddressInfo addressInfo ) {
		
	CustomerInfor customerInfor = modelMapper.map(addressInfo,CustomerInfor.class);
	 
	CustomerInfor CustomerInforUpdated = customerInforDao.save(customerInfor);
           
	
		return ResponseEntity.ok(CustomerInforUpdated);
	}

//orderCreation method
@CrossOrigin(origins="http://localhost:3000/")
@PostMapping(path="/orderCreation",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> OrderMeth(@ModelAttribute OrderDto orderDto) throws Exception{
	
	 double amount = orderDto.getAmount();
	 String currency = orderDto.getCurrency();
	 String receipt = orderDto.getReceipt();
	 String notes_key_1 = orderDto.getNotes_key_1();
	
	
	 Order orderRes = razorOrder.OrderMethod(amount,currency,receipt,notes_key_1);
	
	 String order_id = orderRes.toJson().getString("id");
	 double order_Amount   = orderRes.toJson().getDouble("amount");
	 
	 orderResponse.setOrder_id(order_id);
	 orderResponse.setOrder_Amount(order_Amount);
	 
	 System.out.println(orderRes);
	 
	return ResponseEntity.ok(orderResponse);
}



@CrossOrigin(origins="http://localhost:3000/")
@PostMapping(path="/PaymentCreation",produces= MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> PaymentMeth(@ModelAttribute PaymentDto paymentDto) throws Exception{
	
	CustomerInfor customerInfo  =  modelMapper.map(paymentDto,CustomerInfor.class);
	          
	  System.out.println("this dto get "+customerInfo.getAddress());
	  
	  List<PaymentDetails>  paydetail= customerInfo.getPaymentDetails();
	  
	  PaymentDetails paymentDetails    =  paydetail.get(0);
	  
	  System.out.println("this dto get payment "+paymentDetails.getPaymentId());
	  
	 double amount = paymentDto.getAmount();
	 String currency = paymentDto.getCurrency();
	 String receipt = paymentDto.getReceipt();
	 String notes_key_1 = paymentDto.getNotes_key_1();
	 
	 boolean checkBox = paymentDto.isNews_offers();
	 
	 System.out.println(checkBox);
	 
	
	
	 CustomerInfor customerInfor = new CustomerInfor();
		
	 
	 
	 
	 CustomerInfor CustomerInfo  = customerInforDao.save(customerInfo);
	 
	 
	 System.out.println("amount----"+amount);
	 
	Map<String,String> jsonRes = new HashMap<>();
	
	jsonRes.put("status","payment sucess");
	
	return ResponseEntity.ok(jsonRes);
}      

 
@CrossOrigin(origins="http://localhost:3000/",allowCredentials="true") 
@GetMapping(path="/feignClient",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<CartDataResponse> feign(@CookieValue("cartId") String cookieValue){
	
	Integer cartIdValue = Integer.valueOf(cookieValue);
	
	CartDataResponse cartDataResponse = ecommerceServiceRes.getcartResponse(cartIdValue);
	
	double amount = cartDataResponse.getTotalCartValue();
	
//	Object orderRes = razorOrder.OrderMethod(amount,currency,receipt,notes_key_1);
	
	
	return ResponseEntity.ok(cartDataResponse);
	
	
}

@CrossOrigin(origins="http://localhost:3000/",allowCredentials="true") 
@GetMapping(path="/feignClientDelete",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<CartDeleteResponse> feignDelete(@CookieValue("cartId") String cookieValue){
	
	 Integer cartIdValue = Integer.valueOf(cookieValue);
	
	 String cartID = String.valueOf(cartIdValue);
	 
	 Instant instant = Instant.now();
	 
	 CartDeleteResponse  cartDeleteResponse  = ecommerceServiceRes.delete(cartIdValue);
	
	 String	stHeader ="cartId="+cartID+"; expires= Thu, 18 Dec 2013 12:00:00 UTC; Path=/";
	   
	   HttpHeaders header= new HttpHeaders();
	               header.add("Set-Cookie",stHeader);
	 
	 
	 return ResponseEntity.status(HttpStatus.OK).headers(header).body(cartDeleteResponse);
}



	
@InitBinder
public void initBinder(WebDataBinder binder) {
	

	
	System.out.println(binder);
	

	
	
	
	DoubleEditor doubleEditor = new DoubleEditor();
	
	PaymentDetailEditor paymentDetailEditor = new PaymentDetailEditor(); 
	
	binder.registerCustomEditor(Double.class,"amount",doubleEditor);
	
	binder.registerCustomEditor(List.class,"paymentDetails",paymentDetailEditor);;

	System.out.println("this is init binder");
	
}


}
