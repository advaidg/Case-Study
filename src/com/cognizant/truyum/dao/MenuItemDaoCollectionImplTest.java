package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
public static void main(String[] args) throws ParseException {
	testGetMenuItemListAdmin();
	testGetMenuItemListCustomer();
	testModifyMenuItem();
}

public static void testGetMenuItemListAdmin() throws ParseException
{
	MenuItemDaoCollectionImpl MenuItemDao = new MenuItemDaoCollectionImpl();
	
	List<MenuItem> menuItems = MenuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItems) 
			{
			System.out.println(menuItem);
			}
}
public static void testGetMenuItemListCustomer() throws ParseException
{
	MenuItemDaoCollectionImpl MenuItemDao= new MenuItemDaoCollectionImpl();
	List<MenuItem> menuItems =MenuItemDao.getMenuItemListCustomer();
	for(MenuItem menuItem : menuItems)
	{
		System.out.println(menuItem);
	}
}
public static void testModifyMenuItem() throws ParseException
{
	MenuItem check= new MenuItem(1, "Berger", 99.00f, true,
			DateUtil.convertToDate("17/03/2018"), "Main Course",
			true);
	MenuItemDaoCollectionImpl MenuItemDao= new MenuItemDaoCollectionImpl();
	MenuItemDao.modifyMenuItem(check);
	MenuItemDao.getMenuItem(1);
	
}
public static void testGetMenuItem()
{
	
}
}
