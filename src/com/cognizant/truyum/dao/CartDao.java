package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(long userId);
	
	public  List<MenuItem> getAllCartItems(long userId);
	
	public  void removeCartItem(long userUd,long menuItemId);

	
	
}
