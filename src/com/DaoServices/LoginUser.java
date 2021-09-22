package com.DaoServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 
  
public class LoginUser
{
	Statement stmt;
	 Connection con;
	 ResultSet rs ;
	 PreparedStatement ps;
	public LoginUser()
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
	public   boolean validateUser(String uname,String pwd)
	{
		boolean status=false;
		
		try
		{
			ps=con.prepareStatement("Select * from users where Username=? and  Password=?");
			ps.setString(1,uname);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return status;
	}
}