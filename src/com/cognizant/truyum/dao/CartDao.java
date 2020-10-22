package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public static void addCartItem(long userId)
	{
		
	}
	public static List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		return null;
		
	}
	public static void removeCartItem(long userUd,long menuItemId)
	{
		
	}
	
	
}
