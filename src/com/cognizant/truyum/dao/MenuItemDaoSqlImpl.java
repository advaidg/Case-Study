package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItem = new ArrayList<>();
		String query = "Select* from menu_item";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			long id = rs.getLong(1);
			String name = rs.getNString(2);
			float price = rs.getFloat(3);
			boolean active = rs.getBoolean(4);
			Date dateOfLaunch = new DateUtil().convertToDate(rs.getNString(5));
			String category = rs.getNString(6);
			boolean freeDelivery = rs.getBoolean(7);
			MenuItem m = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			menuItem.add(m);
		}
		return menuItem;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItem = new ArrayList<>();
		String query = "Select *from menu_item where me_active = TRUE AND me_dol < now();";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			long id = rs.getLong(1);
			String name = rs.getNString(2);
			float price = rs.getFloat(3);
			boolean active = rs.getBoolean(4);
			Date dateOfLaunch = new DateUtil().convertToDate(rs.getNString(5));
			String category = rs.getNString(6);
			boolean freeDelivery = rs.getBoolean(7);
			MenuItem m = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			menuItem.add(m);
		}
		return menuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy=MM-dd");
		Connection con = ConnectionHandler.getConnection();
		String query = "UPDATE TABLE menu_item SET me_name='?'me, me_price=?, me_active=?, me_dol='?', me_cat='?',me_freedel=? WEHRE me_id=?)";
		PreparedStatement ps = null;
		ps.setString(1, menuItem.getName());
		ps.setFloat(2, menuItem.getPrice());
		ps.setBoolean(3, menuItem.isActive());
		ps.setString(4, formatter.format(menuItem.getDateOfLaunch()));
		ps.setString(5, menuItem.getCategory());
		ps.setBoolean(6, menuItem.isFreeDelivery());
		ps.setLong(7, menuItem.getId());
		ps.executeQuery();
		

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		MenuItem m =null;
		Connection con = ConnectionHandler.getConnection();
		String query = "SELECT* FROM menu_item WHERE me_id=?;";
		PreparedStatement ps = null;
		ps.setLong(1, menuItemId);
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			long id = rs.getLong(1);
			String name = rs.getNString(2);
			float price = rs.getFloat(3);
			boolean active = rs.getBoolean(4);
			Date dateOfLaunch = new DateUtil().convertToDate(rs.getNString(5));
			String category = rs.getNString(6);
			boolean freeDelivery = rs.getBoolean(7);
			m = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			
			break;

		}

		return m;
	}

}
