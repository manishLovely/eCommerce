package com.payment.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.Repository.CustomerInforRepo;
import com.payment.model.CustomerInfor;

import jakarta.persistence.EntityManager;




@Service
public class CustomerInforDaoImpl implements CustomerInforDao {

	
	
	@Autowired
	CustomerInforRepo customerInforRepo;
	@Transactional
	@Override
	public CustomerInfor save(CustomerInfor customerInfor) {
		
		CustomerInfor customerSave = customerInforRepo.save(customerInfor);
		return customerSave;
	
	}

}
