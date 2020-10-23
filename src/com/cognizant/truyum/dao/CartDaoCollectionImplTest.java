package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException, CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}
	public static void testAddCartItem() throws ParseException, CartEmptyException 
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 4);
		List<MenuItem> menuItemList=cartDao.getAllCartItems(1);
		menuItemList.forEach(System.out::println);
		
		
	}
	public static void testGetAllCartItems() throws ParseException, CartEmptyException 
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		List<MenuItem> menuItem=cartDao.getAllCartItems(1);
		menuItem.forEach(System.out::println);
		
		
		
	}
	public static void testRemoveCartItem() throws ParseException, CartEmptyException
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 4);
		cartDao.getAllCartItems(1);
		
		
	}
}
