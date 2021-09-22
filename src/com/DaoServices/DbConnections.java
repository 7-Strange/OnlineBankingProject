package com.DaoServices;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnections
{
	public static Connection createConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb1","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}