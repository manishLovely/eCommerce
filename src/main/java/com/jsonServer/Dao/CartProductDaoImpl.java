package com.jsonServer.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.jsonServer.hibernate.HiberUtils;
import com.jsonServer.model.CartProduct;
import com.jsonServer.model.ProdIds;


@Service
public class CartProductDaoImpl implements CartProductDao{
  
	private int cartProdId;
	
	@Override
	public CartProduct getProduct( ProdIds id) {
		Transaction transaction  =null;
		CartProduct	CartProduct = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
		
			transaction  = session.beginTransaction();
	     	CartProduct = session.get(CartProduct.class,id);
	                      
	        transaction.commit();
			
		}catch(Exception e) {
			
			System.out.println(e);
			transaction.rollback();
			
		}
		
		return CartProduct;
	}
	
	@Override
	public CartProduct IsProdId(String prodids) {
		Transaction transaction = null;
		List<CartProduct> cartProduct = null;
		
		CartProduct cartProduct12 = null;
		
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			cartProduct = session.createQuery("from CartProduct").list(); 
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		for(CartProduct cp:cartProduct) {
			if(cp.getProdId()==prodids) {
				   
				   cartProduct12 = cp;
				   
				   break;
			}
			
			
		}

			return cartProduct12;
		
	}
/*
	@Override
	public List<CartProduct> getCartProductList(int cartId) {
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			    
			transaction  = session.beginTransaction();
			              session.createQuery("").list();
			                                   
			
			
			
			
		}catch(Exception e) {
			
			
		}
		
		
		return null;
	} 
              */

	@Override
	public List<CartProduct> getCartProductList(int cartId) {
		List<CartProduct> cartProductList = null;
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession() ){
		
			Query query = session.createQuery("from CartProduct as cartProd where cartProd.cart.id=:value");
			      query.setParameter("value",cartId);
			      
			 cartProductList =  (List<CartProduct>)query.list() ;     
		}catch(Exception e) {
			
			System.out.println(e);
			transaction.rollback();
		}
		return cartProductList;
	}

	@Override
	public CartProduct getCartProduct(int catrId, String prodId) {
		
		CartProduct cartProduct = null;
		
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
		Query query = 	session.createQuery("from CartProduct as cartProd where prodId=:value1 AND cartProd.cart.id=:value2");
			query.setParameter("value1",prodId );
			query.setParameter("value2",catrId );
			
			 cartProduct = (CartProduct)query.uniqueResult();
			
		}catch(Exception e) {
			
			System.out.println(e);
			transaction.rollback();
		}
		
		
		return cartProduct;
	}

	@Override
	public void deleteCartProduct(CartProduct cartProduct) {
	Transaction transaction = null;
	try(Session session = HiberUtils.getSessionFactory().openSession()){
		transaction = session.beginTransaction();
		session.delete(cartProduct);
		transaction.commit();
	}catch(Exception e) {
		transaction.rollback();
	}
		
		
	}

	
}
