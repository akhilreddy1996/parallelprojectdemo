package org.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class viewtransactions
 */
@WebServlet("/viewtransactions")
public class viewtransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		String mail=session.getAttribute("myuser").toString();
		
		PrintWriter out=response.getWriter();
		
		String date1=request.getParameter("fromdate").toString();
		
		String date2=request.getParameter("todate").toString();
		
		String date11[]=date1.split("-");
		
		String date22[]=date2.split("-");
		
		//System.out.println(date1);
		
		//System.out.println(LocalDate.of(Integer.parseInt(date11[0]), Integer.parseInt(date11[1]), Integer.parseInt(date11[2])));

		System.out.println(LocalDate.of(Integer.parseInt(date22[0]), Integer.parseInt(date22[1]), Integer.parseInt(date22[2])));

		
		LocalDate fromdate=LocalDate.of(Integer.parseInt(date11[0]), Integer.parseInt(date11[1]), Integer.parseInt(date11[2]));
		
		LocalDate todate=LocalDate.of(Integer.parseInt(date22[0]), Integer.parseInt(date22[1]), Integer.parseInt(date22[2]));

		
		ILoginService loginService=new LoginServiceImpl();

		List<Transaction> transactions=new ArrayList<>();
		
		transactions = loginService.getalltransactions(mail);
		
		if(todate.isAfter(fromdate))
		{
			
			out.println("	\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<table>\r\n" );
					
		for(Transaction trans : transactions)
		{
			if(trans.getTransdate().isAfter(fromdate) && trans.getTransdate().isBefore(todate))
			{
				out.println(	"<tr>\r\n" + 
					"<td>" + trans.getAmount()
					
					+ "</td>\r\n" + 
					"<td>" + trans.getDescription()
					+ "</td>\r\n" + 
					"<td>" + trans.getTranstype()
					+ "</td>\r\n" + 
					"</tr>\r\n" );
		}
		}
		  			out.println("</table>\r\n" + 
					"</body>\r\n" + 
					"</html>	\r\n" + 
					"	");
			
		}
	 }

}
