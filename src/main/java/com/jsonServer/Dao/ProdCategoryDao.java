package com.jsonServer.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsonServer.exception.DuplicateException;
import com.jsonServer.model.ProdCategory;


public interface ProdCategoryDao {
	
	public void SaveProdCat(ProdCategory prodCategory) throws DuplicateException  ;
	
	public void UpdateProdCat(ProdCategory prodCategory);
	
	public ProdCategory getProdCat(long id);
	
	public List<ProdCategory> getAllProdCat();
	
	public void deleteProdCat(long id);
	

}
