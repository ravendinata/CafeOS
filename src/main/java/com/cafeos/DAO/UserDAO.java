package com.cafeos.DAO;

import com.cafeos.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO 
{
	public static int save(User u)
	{
		int status = 0;
		
		try
		{
			Connection con = ConHandler.getConnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO user(fName, lName, email, password, isAdmin) values(?,?,?,?,?);");
			
			pst.setString(1, u.getfName());
			pst.setString(2, u.getlName());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			pst.setInt(5, u.getIsAdmin());
			
			status = pst.executeUpdate();
		}
		catch (Exception ex) { System.out.println(ex); }
		
		return status;
	}
	
	
	public static int update(User u)
	{
		int status = 0;
		
		try
		{
			Connection con = ConHandler.getConnection();
			PreparedStatement pst = con.prepareStatement("UPDATE user SET fName=?, lName=?, email=?, password=? WHERE userId=?;");
				
			pst.setString(1, u.getfName());
			pst.setString(2, u.getlName());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			
			pst.setInt(5, u.getUserId()); // <= WHERE Condition
		}
		catch (Exception ex) { System.out.println(ex); }
		
		return status;
	}
	
	public static int delete(User u)
	{
		int status = 0;
		
		try
		{
			Connection con = ConHandler.getConnection();
			PreparedStatement pst = con.prepareStatement("DELETE FROM user WHERE userId=?;");
			
			pst.setInt(1, u.getUserId()); // <= WHERE Condition
		}
		catch (Exception ex) { System.out.println(ex); }
		
		return status;
	}
	
	public static List<User> getAllUser()
	{
		List<User> list = new ArrayList<User>();
		
		try
		{
			Connection con = ConHandler.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM user;");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				User u = new User();
				
				u.setUserId(rs.getInt("userId"));
				u.setfName(rs.getString("fName"));
				u.setlName(rs.getString("lName"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setIsAdmin((short)rs.getInt("isAdmin"));
				
				list.add(u);
			}
		}
		catch (Exception ex) { System.out.println(ex); }
		
		return list;
	}
	
	public static User getById(int id)
	{
		User u = null;
		
		try
		{
			Connection con = ConHandler.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM user WHERE id=?;");
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			u = new User();
			
			while (rs.next())
			{
				u.setUserId(rs.getInt("userId"));
				u.setfName(rs.getString("fName"));
				u.setlName(rs.getString("lName"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setIsAdmin((short)rs.getInt("isAdmin"));
			}
		}
		catch (Exception ex) { System.out.println(ex); }
		
		return u;
	}
}