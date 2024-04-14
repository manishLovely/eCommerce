package com.jsonServer.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.jsonServer.exception.DuplicateException;
import com.jsonServer.hibernate.HiberUtils;
import com.jsonServer.model.CouponCode;
@Service
public class CouponCodeDaoImpl implements CouponCodeDao {

	private String dubExceptionMessage = "";
	
	@Override
	public void SaveCouponCode(CouponCode couponCode) throws DuplicateException  {
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
		        
	   transaction = session.beginTransaction();
			session.save(couponCode);
       
	   transaction.commit();		
			
		}catch(Exception e) {
			
			try {
				System.out.println(e);
				
				System.out.println(e.getMessage());
				String error = e.getMessage();
				char[] erroArray = error.toCharArray();
				StringBuffer sb = new StringBuffer();
				
		  outer:for(int i =0;i<erroArray.length;i++) {
			        int j = 0;
			        int p =0;
					if(erroArray[i]=='[') {
					boolean	whileSetter = true;
		            while(whileSetter){
				    	int k = i+1;
				    	
					   	
						
							sb.insert(p,erroArray[k]);
							
							
							i++;
							if(erroArray[k]=='\'') {
								
								
								
								if(j==1) {
								break outer;	
								}
								
							   j++;
							}
							
							p++;
						}
						
					}
					
					continue outer;
					
				}
		     if(sb.toString().startsWith("Duplicate")) {
		    	 
		    	 dubExceptionMessage = sb.toString();
		    	 throw new  DuplicateException();
		    	// System.out.println(sb);
		     }
				}catch(Exception exc) {
					System.out.println(exc.getClass().getName());
					System.out.println(dubExceptionMessage);
					if(exc.getClass().getName()=="com.jsonServer.exception.DuplicateException") {
						throw new  DuplicateException(dubExceptionMessage);
						
					}
				}
			transaction.rollback();
			
		}
		
	}

	@Override
	public CouponCode getCouponCode(String coupon) {
		Transaction transaction = null;
		
		CouponCode couponCode = null;
		
		try(Session session = HiberUtils.getSessionFactory().openSession()){
		   
			transaction = session.beginTransaction();
			Query query = session.createQuery("from CouponCode as C Where C.CouponCode=:coupon");
			
			query.setParameter("coupon",coupon);
			
			 couponCode = (CouponCode)query.uniqueResult();
			
		    
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		return couponCode;
	}

}
