package com.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoServices.Transfer;
import com.DaoServices.Withdraw;


/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter pw= response.getWriter();
		
		int acc=Integer.parseInt(request.getParameter("accNo"));
		int acc1=Integer.parseInt(request.getParameter("accNo1"));
		double amt=Double.parseDouble(request.getParameter("amt"));
		
		Transfer t1=new Transfer();
		boolean result= t1.transfer(acc, acc1, amt);
		if(result==true)
		{
			System.out.println("Successful");
			response.sendRedirect("congrats.html");
		}
		else
		{
			System.out.println("Failed!!");
			pw.println("Something went wrong...!");
			pw.println("<br><br>Invalid Credentials...!");
			pw.println("<br><br><form action =\"Transfer.html\"><input type=\"Submit\" value=\"Return\"</form>");
		}
	
		
	}

}
