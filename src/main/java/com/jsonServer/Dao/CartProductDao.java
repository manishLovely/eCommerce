package com.jsonServer.Dao;

import java.util.List;

import com.jsonServer.model.CartProduct;
import com.jsonServer.model.ProdIds;

public interface CartProductDao {

	public CartProduct getProduct( ProdIds id) ;
	
	public CartProduct IsProdId(String prodids);
	
	public List<CartProduct> getCartProductList(int cartId);
	
	public CartProduct getCartProduct(int catrId,String prodId);
		
	public void deleteCartProduct(CartProduct cartProduct);
}
