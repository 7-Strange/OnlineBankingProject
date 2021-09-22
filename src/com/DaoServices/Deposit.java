package com.DaoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.account.account;
import com.DaoServices.DbConnections;

public class Deposit
{
	account acc;
	Connection con=DbConnections.createConnection();
	PreparedStatement pst;
	ResultSet rs;
	public account retriveAccDetails(int accNo) 
	{
		acc=null;
		try
		{
			pst=con.prepareStatement("select Accno,Balance from users where Accno=?");
			pst.setInt(1, accNo);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				acc=new account();
				acc.setAccNo(accNo);
				
				acc.setAccBal(rs.getDouble("Balance"));
			}
			else
			{
				System.out.println("Record Not Found");
				acc=null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return acc;
	}
	public int updateAccountBalance(int accountNo, double amount)
	{
		int cnt=0;
		try 
		{
			pst=con.prepareStatement("update users set Balance=? where Accno=?");
			pst.setDouble(1, amount);
			pst.setInt(2, accountNo);
			cnt=pst.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public double deposit(int accountNo, double amount)
	{
		account dbacc=retriveAccDetails(accountNo);
		double updatedBal;
		if (dbacc!=null) 
		{
			acc.setAccBal(dbacc.getAccBal()+amount); 
			updatedBal=acc.getAccBal();
			updateAccountBalance(accountNo, updatedBal);
		}
		else
		{
			updatedBal=0.0f;
			System.out.println("Invalid account no");
		}
		return updatedBal;
	}

}