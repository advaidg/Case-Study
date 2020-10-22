package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl {

	private static Map<Long,Cart> userCarts =new HashMap<Long,Cart>();
	
	public CartDaoCollectionImpl()
	{
		
	}
	public void addCartItem(long userId,long menuItemId)
	{
		
	}
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		return null;
		
	}
	public void removeCartItem(long userId,long menuItemId)
	{
		
	}

}
