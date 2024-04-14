package com.jsonServer.Dao;



import com.jsonServer.model.Cart;

public interface CartDao {
    
	public Integer saveCart(Cart cart);
	
	public void updateCart(Cart cart);
	
	public Cart getCart(int id);
	
	public void deleteCart(int id);
	
}
