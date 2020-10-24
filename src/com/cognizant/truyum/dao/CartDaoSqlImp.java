package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

class CartDaoSqlImp implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = null;
		String query="INSERT INTO cart (ct_menu_id,ct_user_id) VALUE (?,?);";
		ps=con.prepareStatement(query);
		ps.setLong(1, menuItemId);
		ps.setLong(2,userId);
		if(ps.executeUpdate()>0)
			{System.out.println("Added Successfully");}
		ps.clearParameters();
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = null;
		List<MenuItem> menuItem= new ArrayList<>();
		Cart cart= new 	Cart(menuItem);
		String query="SELECT * FROM menu_item m JOIN cart c on m.me_id=c.ct_menu_id WHERE c.ct_user_id=?;";
		ps=con.prepareStatement(query);
		ps.setLong(1,userId);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{	
			long id = rs.getLong(1);
			String name = rs.getNString(2);
			float price = rs.getFloat(3);
			boolean active = rs.getBoolean(4);
			Date dateOfLaunch = rs.getDate(5);
			String category = rs.getNString(6);
			boolean freeDelivery = rs.getBoolean(7);
			MenuItem m= new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			menuItem.add(m);
			ps.clearParameters();
		}
		String query1="SELECT sum(m.me_price) FROM menu_item m JOIN cart c on m.me_id=c.ct_menu_id WHERE c.ct_user_id=?;";
		PreparedStatement ps1 = null;
		ps1=con.prepareStatement(query1);
		ps1.setLong(1,userId);
		ResultSet rs1=ps1.executeQuery();
		
		while(rs1.next())
		{
			double price=rs1.getFloat(1);
			cart.setTotal(price);
			ps1.clearParameters();
		}
		
		
		return menuItem;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = null;
		String query = "DELETE FROM cart WHERE ct_user_id=? AND ct_menu_id=?;";
		ps=con.prepareStatement(query);
		ps.setFloat(1, userId);
		ps.setFloat(2, menuItemId);
		ps.execute();
		ps.clearParameters();
		
	}

}
