package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
private static MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
		System.out.println("TESTIN MENU_ITEMS SQL IMPLEMENTATION");
		System.out.println("TESTING GET MENU LIST ADMIN");
		testGetMenuItemListAdmin();
		System.out.println("TESTING GET MENU LIST CUSTOMER ");
		testGetMenuItemListCustomer();
		System.out.println("TESTING MODIFY MENUITEM(5)");
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		System.out.println("TEST GET MENU ITEM (MENU ITEM ID 2)");
		testGetMenuItem();
	}
	
	public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> itemAdminList = menuItemDao.getMenuItemListAdmin();
		itemAdminList.forEach(System.out::println);
	}
	
	public static void testGetMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> itemCustomerList = menuItemDao.getMenuItemListCustomer();
		itemCustomerList.forEach(System.out::println);
	}

	public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException, ParseException {
		MenuItem menuItem = new MenuItem(5, "Dark Chocolate ", 40.0f, true, new DateUtil().convertToDate("15/03/2019"), "Desert", true);
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {
		MenuItem menuItem = menuItemDao.getMenuItem(2);
		if(menuItem == null) {
			System.out.println("The Item does not exist in our database");
			return;
		}
		System.out.println(menuItem);
	}
}
