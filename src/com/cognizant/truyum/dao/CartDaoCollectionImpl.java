package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class CartDaoCollectionImpl implements CartDao {

	private static Map<Long,Cart> userCarts;
	
	public CartDaoCollectionImpl() throws ParseException
	{
		if(userCarts==null)
		{
			userCarts=new HashMap<Long,Cart>();
			MenuItem menuItem = new MenuItem(4, "Sandwich", 80.00f, true,
					DateUtil.convertToDate("22/10/2020"), "Main Course", false);
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			
			Cart cart = new Cart(menuItemList,80.0);
			Long user = (long) 1;
			userCarts.put(user, cart);
		}
	}
	public void addCartItem(long userId,long menuItemId) throws ParseException
	{	
		MenuItemDaoCollectionImpl MenuItemDao= new 	MenuItemDaoCollectionImpl();
		MenuItem menuItem=MenuItemDao.getMenuItem(menuItemId);
		for(Entry<Long, Cart> e:userCarts.entrySet())
		{
			if(e.getKey()==menuItem.getId())
			{	List<MenuItem> menuList= new ArrayList<MenuItem>();
				Cart cart=e.getValue();
				menuList=cart.getMenuItemList();
				menuList.add(menuItem);
				cart.setMenuItemList(menuList);
				
			}
			else {
				List<MenuItem> menuItemList= new ArrayList<MenuItem>();
				menuItemList.add(menuItem);
				Cart cart = new Cart(menuItemList, menuItem.getPrice());
				userCarts.put(userId, cart);

			}
		}
	}
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		return null;
		
	}
	public void removeCartItem(long userId,long menuItemId)
	{
		
	}

}
