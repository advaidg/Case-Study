package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		// TODO Auto-generated method stub
		System.out.println("TESTING CART SQL IMPLEMENTATION ");
		System.out.println("TESTING ADD ITEM TO CART(1,1) && (1,2)");
		testAddCartItem();
		System.out.println("TESTING GETALLCARTITEM(USER_ID =2)");
		testGetAllCartItem();
		System.out.println("TESTING REMOVE CART ITEM (USER_ID=1,MENU_ITEM=1 ");
		testRemoveCartItem();
	
	}
	
	public static void testAddCartItem() throws ClassNotFoundException, IOException, SQLException {
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		cartDaoImpl.addCartItem(1, 1);
		cartDaoImpl.addCartItem(1, 2);
		
	}
	
	public static void testGetAllCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		int user_id = 2;
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		
			List<MenuItem> menuItemList = cartDaoImpl.getAllCartItems(user_id);
			for(MenuItem item : menuItemList) {
				System.out.println(item);
			}
		
		
	}
	
	public static void testRemoveCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		long userId = 1;
		System.out.println("Before");
	
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		System.out.println("After");
		
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
	}
}
	
	
			

