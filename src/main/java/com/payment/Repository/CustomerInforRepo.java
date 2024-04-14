package com.payment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.CustomerInfor;
@Repository
public interface CustomerInforRepo extends JpaRepository<CustomerInfor,Integer> {

}
