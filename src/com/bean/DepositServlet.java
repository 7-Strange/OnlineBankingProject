package com.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoServices.Deposit;
import com.DaoServices.RegisterUser;
import com.account.account;
import com.user.Userinfo;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter(); 
		int acc=Integer.parseInt(request.getParameter("accNo"));
		double amt=Double.parseDouble(request.getParameter("amt"));
		
		Deposit d=new Deposit();
		double ub=d.deposit(acc,amt);
		
		pw.println("The Updated Balance is "+ub);
		pw.println("<br><br><form action =\"congrats.html\"><input type=\"Submit\" value=\"Return\"</form>");		
		
		
		//response.sendRedirect("congrats.html");
		
		
	}

}