package com.payment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.PaymentDetails;
@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails,Integer> {

}
