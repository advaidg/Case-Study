package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, CartEmptyException {
		// TODO Auto-generated method stub
		System.out.println("Inside CartDaoSqlImplTest's Main");
		System.out.println("AddCartItem invoked");
		testAddCartItem();
		System.out.println("getAllCartItem invoked");
		testGetAllCartItem();
		System.out.println("removeCartItem invoked");
		testRemoveCartItem();
		testGetAllCartItem();
		System.out.println("Completed..");
		
	}
	
	public static void testAddCartItem() throws ClassNotFoundException, IOException, SQLException {
		CartDaoSqlImp cartDaoImpl = new CartDaoSqlImp();
		cartDaoImpl.addCartItem(1, 1);
		cartDaoImpl.addCartItem(1, 2);
		cartDaoImpl.addCartItem(2, 2);
		cartDaoImpl.addCartItem(2, 3);
		cartDaoImpl.addCartItem(2, 4);
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
