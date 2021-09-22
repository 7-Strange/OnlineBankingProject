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

import com.DaoServices.RegisterUser;
import com.user.Userinfo;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String age =request.getParameter("age");
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		String acctype=request.getParameter("accType");
		String balance=request.getParameter("bal");
		
		Userinfo user = new Userinfo ();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAge(age);
		user.setUsername(username);
		user.setPassword(password);
		user.setAcctype(acctype);
		user.setBalance(balance);
		
		try
		{
		RegisterUser registerUser = new RegisterUser();
		registerUser.registeruser(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		  response.sendRedirect("HomePage.html");
		
	
		
		
	}

}
