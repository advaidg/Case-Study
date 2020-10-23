package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
		System.out.println("VERIFYING WHETHER ITEM REMOVED OR NOT BY INVOKING GETALLCARTITEM(USER_ID =2)  ");
		testGetAllCartItem();
		System.out.println("Completed..");
		
	}
	
	public static void testAddCartItem() throws ClassNotFoundException, IOException, SQLException {
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		cartDaoImpl.addCartItem(1, 1);
		cartDaoImpl.addCartItem(1, 2);
		
	}
	
	public static void testGetAllCartItem() throws ClassNotFoundException, IOException, SQLException {
		int user_id = 2;
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		try {
			List<MenuItem> menuItemList = cartDaoImpl.getAllCartItems(user_id);
			for(MenuItem item : menuItemList) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			System.out.printf("The user id number %f did not buy anything\n",user_id);
			e.printStackTrace();
		}
	}
	
	public static void testRemoveCartItem() throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		long userId = 1;
		System.out.println("\nBefore Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		System.out.println("\nAfter Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
