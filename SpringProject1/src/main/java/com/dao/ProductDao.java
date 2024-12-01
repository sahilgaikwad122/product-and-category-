package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Category;
import com.model.Product;
import com.util.MyDatabase;

public class ProductDao {

	public int insertStudentt(Product s)
	{
		int check = 0;
		Connection con = MyDatabase.myConnection();
		String sql = "insert into Product(name , price , categoryId)values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setInt(2, s.getPrice());
			pst.setInt(3, s.getCategoryId());
		
			check = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {MyDatabase.closeConnection(pst, con);}
		return check ;
	}
	
	public static Product findProductById(int id)
	{
		Product s1 = null;
		String sql = "select * from Product where id=?";
		try(Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, id);
			
		}catch(SQLException e) {e.printStackTrace();}
		return s1;
	}	
	public int updateProduct(Product s)
	{
		int check = 0 ;
		String sql = "UPDATE Product SET name = ? , price=? , categoryId = ? WHERE id = ?";
		try(Connection con = MyDatabase.myConnection();
			PreparedStatement pst = con.prepareStatement(sql);){
				pst.setString(1, s.getName());
				pst.setInt(2, s.getPrice());
				pst.setInt(3, s.getCategoryId());
	
				check = pst.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return check;
	
	}
	
	public int deleteProductById(int id)
	{
		int check = 0;
		String sql = "delete * from Product where id=?";
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, id);
			check = pst.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return check;

	}
}


