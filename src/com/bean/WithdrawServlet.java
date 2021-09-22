package com.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoServices.Withdraw;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw= response.getWriter();
		
		int acc=Integer.parseInt(request.getParameter("accNo"));
		double amt=Double.parseDouble(request.getParameter("amt"));
		
		Withdraw W=new Withdraw();
		boolean result =W.withdraw(acc,amt);
		double ub = W.Accbal(acc);
		
		
		if (result==true)
		{
			pw.println("The Updated Balance After Withdraw is  is "+ub);
			pw.println("<br><br><form action =\"congrats.html\"><input type=\"Submit\" value=\"Return\"</form>");
		}
		else
		{
			pw.println("Something went wrong...!");
			pw.println("Invalid Input...!");
			pw.println("<br><br><form action =\"Withdraw.html\"><input type=\"Submit\" value=\"Return\"</form>");
		}
		
		
		
		
	}

}
