package org.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capg.model.Account;
import org.capg.service.ILoginService;
import org.capg.service.LoginServiceImpl;


@WebServlet("/createaccservlet")
public class createaccservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public createaccservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ILoginService loginService=new LoginServiceImpl();
     
		HttpSession session=request.getSession();
		
		String mail=session.getAttribute("myuser").toString();
		
		
		Account acc=new Account();
		
		String acctype=request.getParameter("accountType");
		
		String opbal=request.getParameter("balance");
		
		String description="this account is"+acctype;
	
		acc.setAccountType(acctype);
		acc.setDescription(description);
		acc.setOpeningBalance(Double.parseDouble(opbal));
		acc.setOpeningDate(LocalDate.now());
		
		if(loginService.createaccount(acc,mail))
		{
			response.sendRedirect("view/createAccount.html");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("iam not a zomato or swiggy DBA to allow my users to create multiple accounts..u already have a " + acc.getAccountType() +" account so dont act smart");
		}
		
	}

}
