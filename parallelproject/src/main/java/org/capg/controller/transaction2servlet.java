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

/**
 * Servlet implementation class transaction2servlet
 */
@WebServlet("/transaction2servlet")
public class transaction2servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ILoginService loginService=new LoginServiceImpl();

		HttpSession session=request.getSession();
		
		String mail=session.getAttribute("myuser").toString();
		
	   Transaction trans=new Transaction();
	   
		String amt=request.getParameter("amount");
		
		String transtype="credit";
		
		String accno=request.getParameter("accno");

		String accno2=request.getParameter("accno2");
		
		String description=request.getParameter("Description");
		
		
		trans.setAmount(amt);

		trans.setDescription(description);
		
		trans.setTransdate(LocalDate.now());
		
		trans.setTranstype(transtype);
		
		int acc1=Integer.parseInt(accno);
		
		int acc2=Integer.parseInt(accno2);
		
		loginService.addtransaction2(trans, acc1, acc2, mail);
		
	}
	
	

}
