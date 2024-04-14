package com.jsonServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsonServer.Dao.ProdCategoryDao;
import com.jsonServer.Dao.ProdCategoryDaoImp;
import com.jsonServer.Dto.ProductCatDto;
import com.jsonServer.Dto.ProductDataDto;
import com.jsonServer.exception.DuplicateException;
import com.jsonServer.model.ProdCategory;
import com.jsonServer.model.ProductInfo;

import jakarta.transaction.Transactional;

@Service
public class ProdCatServiceImp {
	@Autowired 
	ProdCategoryDao prodCategoryDao;
	    
	
	public void SaveCatService(ProdCategory prodCategory) throws IOException, DuplicateException {
		
		prodCategoryDao.SaveProdCat(prodCategory);
	
	}

	
	public void UpdateCatService() {
		// TODO Auto-generated method stub
		
	}

	
	public void GetCatService() {
		// TODO Auto-generated method stub
		
	}

	
	public void GetAllCatService() {
		// TODO Auto-generated method stub
		
	}

	
	public void DelteCatService() {
		// TODO Auto-generated method stub
		
	}

}
