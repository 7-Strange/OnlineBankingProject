package com.account;

public class account
{
		private int accNo;
		private String accType;
		private double accBal;
		
		
		public account()
		{
			
		}
		public account(String accType,float accBal)
		{
			this.accType=accType;
			this.accBal=accBal;
		}
		public void setAccNo(int no)
		{
			accNo=no;
		}
		public void setAccType(String type)
		{
			accType=type;
		}
		public void setAccBal(double d) 
		{
			accBal=d;
		}
		//getter method
		public int getAccNo()
		{
			return accNo;
		}
		public String getAccType()
		{
			return accType;
		}
		public double getAccBal()
		{
			return accBal;
		}
	
}
