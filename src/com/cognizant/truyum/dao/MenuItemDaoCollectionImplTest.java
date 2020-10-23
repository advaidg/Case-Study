package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	static MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

	public static void main(String[] args) {
		System.out.println("TESTING MENU ITEM LIST");
		testGetMenuItemListAdmin();
		testGetMenuListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		
		menuItemDao = new MenuItemDaoCollectionImpl();

		List<MenuItem> menuItems = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuListCustomer() {
		System.out.println("TESTING MENU ITEM LIST CUSTOMER ");
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		System.out.println(menuItemDao.toString());
		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	public static void testModifyMenuItem() {
		System.out.println("TESTING MODFY ITEM");
		MenuItem check = new MenuItem(1, "Berger", 1000.00f, true, new DateUtil().convertToDate("17/03/2018"),
				"Main Course", true);
		MenuItemDaoCollectionImpl MenuItemDao = new MenuItemDaoCollectionImpl();
		MenuItemDao.modifyMenuItem(check);
		MenuItemDao.getMenuItem(1);
		testGetMenuItemListAdmin();
		

	}

	public static void testGetMenuItem() {
		System.out.println("TESTING GET MENU ITEMS");
		MenuItem newMenuItem = new MenuItem(1, "Sandwich", 109.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
		menuItemDao.modifyMenuItem(newMenuItem);
		MenuItem modifiedMenuItem = menuItemDao.getMenuItem(1);
		System.out.println(modifiedMenuItem.toString());

	}
}
