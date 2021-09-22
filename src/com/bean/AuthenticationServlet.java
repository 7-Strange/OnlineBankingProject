package com.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoServices.LoginUser;


/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		
		LoginUser LoginUser = new LoginUser();
		if(LoginUser.validateUser(username,password))
		{
			pw.println("Login Successfully");
			response.sendRedirect("BankTransact.html");
			
			//response.sendRedirect();
		}
		else
		{
			pw.println("Something went wrong.!");
			response.sendRedirect("Login.html");
		}
		
		
	}
	


}