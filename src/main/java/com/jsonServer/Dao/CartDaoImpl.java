package com.jsonServer.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.jsonServer.hibernate.HiberUtils;
import com.jsonServer.model.Cart;


@Service
public class CartDaoImpl implements CartDao {

	
	
	@Override
	public Integer saveCart(Cart cart) {
		Transaction transaction = null;
		Integer primaryKey = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			primaryKey  = (Integer)session.save(cart);
			transaction.commit();
		}catch(Exception e){
			
			System.out.println(e);
			transaction.rollback();
			
		}
		return primaryKey;
	}

	@Override
	public void updateCart(Cart cart) {
	
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(cart);
			transaction.commit();
		}catch(Exception e){
			
			
			transaction.rollback();
			
			
		}
		
		
		
	}

	@Override
	public Cart getCart(int id) {
		Transaction transaction  = null;
		Cart cart = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
		     cart =  session.get(Cart.class,id);
			
		    transaction.commit();
		    
			
		
		  }catch(Exception e) {
			
			System.out.print(e);  
			transaction.rollback();
			
		}
		return cart;
		
	}

	@Override
	public void deleteCart(int id) {
		Transaction transaction = null;
		Cart cart = null;
		try(Session session = HiberUtils.getSessionFactory().openSession() ){
			
			 transaction = session.beginTransaction();
			    cart =  session.get(Cart.class,id);
			   session.delete(cart);
			transaction.commit();
		}catch(Exception e) {
			
			System.out.print(e);
			transaction.rollback();
			
		}
		
	}	
	
	
	
	
	
}
