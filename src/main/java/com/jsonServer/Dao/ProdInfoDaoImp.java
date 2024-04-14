package com.jsonServer.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jsonServer.hibernate.HiberUtils;
import com.jsonServer.model.ProdIds;
import com.jsonServer.model.ProductInfo;


@Repository
public class ProdInfoDaoImp implements ProdInfoDao{

	@Override
	public void saveProdInfo( ProductInfo prodInfo) {
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(prodInfo);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
			
		}
		
		
	}

	@Override
	public void UpdateProdInfo(ProductInfo productInfo) {
		Transaction transaction = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.saveOrUpdate(productInfo);
			transaction.commit();
			
		}catch(Exception e) {
			
			System.out.println(e);
			transaction.rollback();
			
		}
		
	}

	@Override
	public ProductInfo getProdInfo(ProdIds id) {
		Transaction transaction = null;
		ProductInfo productInfo = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			productInfo =	session.get(ProductInfo.class,id);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
			
		}
		
		return productInfo;
	}

	@Override
	public List<ProductInfo> getAllProdCat(String  id) {
		Transaction transaction = null;
		List<ProductInfo> productInfo=null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			productInfo = session.createQuery("from ProductInfo").list();
			transaction.commit();
			}catch(Exception e) {
			   System.out.println(e);
			   transaction.rollback();
				
				
			}
		
		return productInfo;
	}

	@Override
	public void deleteProdInfo(String id) {
		Transaction transaction = null;
		ProductInfo productInfo = null;
		try(Session session = HiberUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			productInfo = session.get(ProductInfo.class,id);
			session.delete(productInfo);
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
			}
		
	}

	
	
	
}
