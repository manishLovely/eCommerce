package com.jsonServer.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jsonServer.exception.DuplicateException;
import com.jsonServer.hibernate.HiberUtils;
import com.jsonServer.model.ProdCategory;
@Repository
public class ProdCategoryDaoImp implements ProdCategoryDao{

	
	private String dubExceptionMessage = "";
	
	@Override
	public void SaveProdCat(ProdCategory prodCategory) throws DuplicateException  {
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
	        transaction = session.beginTransaction();	
			session.save(prodCategory);
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
	public void UpdateProdCat(ProdCategory prodCategory) {
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
	        transaction = session.beginTransaction();	
			session.saveOrUpdate(prodCategory);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		
	}
	
	@Override
	public ProdCategory getProdCat(long id) {
		Transaction transaction = null;
		ProdCategory prodCategory=null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
	        transaction = session.beginTransaction();	
	        prodCategory = session.get(ProdCategory.class,id);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		
		return prodCategory;
	}
	
	@Override
	public List<ProdCategory> getAllProdCat(){
		Transaction transaction = null;
		List<ProdCategory> prodCategory=null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
	        transaction = session.beginTransaction();	
	        prodCategory = session.createQuery("from ProdCategory").list();
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		
		return prodCategory;
	}
	
	@Override
	public void deleteProdCat(long id) {
		Transaction transaction = null;
		ProdCategory prodCategory=null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			
	        transaction = session.beginTransaction();	
	        prodCategory =  session.get(ProdCategory.class,id);
			session.delete(prodCategory);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		
	}
	
	
	
	
	
}
