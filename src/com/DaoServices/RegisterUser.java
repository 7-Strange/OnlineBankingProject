package com.DaoServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DaoServices.DbConnections;
import com.user.Userinfo;

public class RegisterUser 
{
	Statement stmt;
	Connection con;
	ResultSet rs ;
	PreparedStatement ps;
	
	public RegisterUser()
	{
		try
		{
			
			
			con = DbConnections.createConnection();			
			stmt=con.createStatement();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	


	public   int  registeruser(Userinfo user)
	{
		int result = 0;
		try {
		
		ps=con.prepareStatement("insert into users (Fname,Lname,Age,Username,Password,AccType,Balance)values(?,?,?,?,?,?,?)");
		ps.setString(1, user.getFirstname());
		ps.setString(2,user.getLastname());
		ps.setString(3, user.getAge());
		ps.setString(4, user.getUsername());
		ps.setString(5, user.getPassword());
		ps.setString(6, user.getAcctype());
		ps.setString(7, user.getBalance());
		
		result = ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result ;
		
	}

}
