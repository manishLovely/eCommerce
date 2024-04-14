package com.jsonServer.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsonServer.model.ProdIds;
import com.jsonServer.model.ProductInfo;


public interface ProdInfoDao {
	
	
	public void saveProdInfo( ProductInfo prodInfo); 
	
	public void UpdateProdInfo(ProductInfo productInfo);
	
	public  ProductInfo getProdInfo(ProdIds id);
	
	public List<ProductInfo> getAllProdCat(String id);
	
	public void deleteProdInfo(String id) ;

}
