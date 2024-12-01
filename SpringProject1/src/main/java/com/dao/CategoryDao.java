package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Category;
import com.model.Category;
import com.util.MyDatabase;

public class CategoryDao {

	public int insertStudent(Category s)
	{
		int check = 0;
		Connection con = MyDatabase.myConnection();
		String sql = "insert into Category(name)values(?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getName());
		
			check = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {MyDatabase.closeConnection(pst, con);}
		return check ;
	}
	
	public Category findCategoryById(int id)
	{
		Category s = null;
		String sql = "select id , name from Category where id=?";
		try(Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			List<Category> list = MyDatabase.studentRowMapper(rs);
			if(!list.isEmpty())
				s = list.get(0);
		}catch(SQLException e) {e.printStackTrace();}
		return s;
	}	
	
	public int updateCategory(Category s)
	{
		int check = 0 ;
		String sql = "UPDATE Category SET name = ? WHERE id = ?";
		try(Connection con = MyDatabase.myConnection();
			PreparedStatement pst = con.prepareStatement(sql);){
				pst.setString(1, s.getName());
	
				check = pst.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return check;
	}	
	
	public int deleteCategoryById(int id)
	{
		int check = 0;
		String sql = "delete from Category where id=?";
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, id);
			check = pst.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return check;
	}
}
