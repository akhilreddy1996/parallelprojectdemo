package org.capg.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capg.model.Transaction;
import org.capg.service.ILoginService;
import org.capg.service.LoginServiceImpl;

@WebServlet("/transaction1servlet")
public class transaction1servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ILoginService loginService=new LoginServiceImpl();

		HttpSession session=request.getSession();
		
		String mail=session.getAttribute("myuser").toString();
		
	   Transaction trans=new Transaction();
	   
		String amt=request.getParameter("amount");
		
		String transtype=request.getParameter("depwi");
		
		String accno=request.getParameter("accno");

		String description=request.getParameter("Description");
		
		trans.setAmount(amt);
		trans.setDescription(description);
		trans.setTransdate(LocalDate.now());
		trans.setTranstype(transtype);
		
		
		int acc=Integer.parseInt(accno);
		
		System.out.println(trans);
		
		loginService.addtransaction1(trans,acc,acc,mail);
		
	}

}
