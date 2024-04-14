package com.payment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.payment.Repository.PaymentDetailsRepo;
import com.payment.model.PaymentDetails;



@Service
public class PaymentDetailsDaoImpl implements PaymentDetailsDao {

	@Autowired
	PaymentDetailsRepo paymentDetailsRepo;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public PaymentDetails save(PaymentDetails paymentDetails) {
		
		
		PaymentDetails savePaymentDetails = paymentDetailsRepo.save(paymentDetails); 	
		
	return savePaymentDetails;	
	}

}
