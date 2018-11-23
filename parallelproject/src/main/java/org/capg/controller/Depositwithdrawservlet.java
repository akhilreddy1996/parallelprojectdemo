package org.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capg.model.Account;
import org.capg.service.ILoginService;
import org.capg.service.LoginServiceImpl;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/Depositwithdrawservlet")
public class Depositwithdrawservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ILoginService loginService=new LoginServiceImpl();

		HttpSession session=request.getSession();
		
		System.out.println("Bhdj");
		String mail=session.getAttribute("myuser").toString();
		
		List<Account> accounts=new ArrayList<>();
				accounts=loginService.getAllAccounts(mail);
		
				
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title></title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
                 "<form name=\"f4\" method=\"post\" action=\"transaction1servlet\">\r\n" + 
				"\r\n" + 
				"<table>\r\n" + 
				"\r\n" + 
				"<tr>\r\n" + 
				"<td>Choose Account : </td>\r\n" + 
				"<td>\r\n" + 
				"\r\n" + 
				"<select name=\"accno\">\r\n" );  
				
		     for(Account account:accounts)
		     {
				out.println( "<option value=\""
						+ account.getAccountNumber()
						+ "\"> " 
						+ account.getAccountNumber() + " - " + account.getAccountType() 
						+ "</option>\r\n" ); 
						
		     }
				
				out.println("</select>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"\r\n" + 
                 "<tr>\r\n" + 
                 "<td>\r\n" + 
                 " <input type=\"radio\" name=\"depwi\" value=\"deposit\"> Deposit\r\n" + 
                 "  <input type=\"radio\" name=\"depwi\" value=\"withdrawal\"> Withdrawal\r\n" + 
                 "</td>\r\n" + 
                 "</tr>	" +
                   "<tr>\r\n" + 
                   "		<td>Amount : </td>\r\n" + 
                   "		<td><input type=\"text\" name=\"amount\"></td>\r\n" + 
                   "		</tr>" +
                   "<tr>\r\n" + 
                   "		<td>Description : </td>\r\n" + 
                   "		<td><input type=\"text\" name=\"Description\"></td>\r\n" + 
                   "		</tr>" +
                   "	\r\n" + 
                   "		<tr>\r\n" + 
                   "		<td><input type=\"submit\" name=\"dwithtransaction\" value=\"Do Transaction\"></td>\r\n" + 
                   "		</tr>	" + 
				"</table>\r\n" + 
				"</form>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		
	}

}
