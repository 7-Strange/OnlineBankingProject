package com.DaoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.account.account;

import com.DaoServices.DbConnections;

public class Transfer 
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
	public boolean transfer(int acc2,int acc1,double amount)
	{
		boolean status=false;
		account dbacc=retriveAccDetails(acc2);
		//withdraw from account1
		double updatedBal;
		if (dbacc!=null) 
		{ 
			if (dbacc.getAccBal()>amount)
			{
				acc.setAccBal(dbacc.getAccBal()-amount); 	
				updatedBal=acc.getAccBal();
				updateAccountBalance(acc2, updatedBal);
				status = true;
			}
			else
			{
				status=false;
			}
		}
		else 
		{
			System.out.println("Account no is incorrect.");
			status = false;
		}	
			
		//deposit to account2
		if (status == true)
		{
			account dbacc1=retriveAccDetails(acc1);
			if (dbacc1!=null) 
			{
				acc.setAccBal(dbacc1.getAccBal()+amount); 
				updatedBal=acc.getAccBal();
				updateAccountBalance(acc1, updatedBal);
				status = true;
			}
			else
			{
				System.out.println("Account no is incorrect.");
				status = false;
			}
		}
		else
		{
			status=false;
		}
		return status;	
	}

}
