package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Category;
import com.model.Product;


public class MyDatabase {

	public static Connection myConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringProject1", "root", "Sahil1007");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static List<Category> studentRowMapper(ResultSet rs) throws SQLException 
	{
		List<Category> list = new ArrayList();
		while(rs.next())
		{
			Category s = new Category();
			s.setId(rs.getInt("id"));
			s.setName(rs.getNString("name"));
		
			list.add(s);
		}
		return list;
	}
	public static List<Product> studentRowMapper1(ResultSet rs) throws SQLException 
	{
		List<Product> list1 = new ArrayList();
		List<Product> list = null;
		while(rs.next())
		{
			Product s1 = new Product();
			s1.setId(rs.getInt("id"));
			s1.setName(rs.getString("name"));
			s1.setPrice(rs.getInt("price"));
			s1.setCategoryId(rs.getInt("categoryId"));
		
			list.add(s1);	
		}
		rs.close();
		return list;
	}
	
	public static void closeConnection(PreparedStatement pst , Connection con) {
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(ResultSet rs ,PreparedStatement pst , Connection con) {
		try {
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Category> productRowMapper(ResultSet rs1) {
		// TODO Auto-generated method stub
		return null;
	}	
}


