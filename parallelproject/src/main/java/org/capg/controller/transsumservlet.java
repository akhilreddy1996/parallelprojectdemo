package org.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/transsumservlet")
public class transsumservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<form method=\"post\" action=\"viewtransactions  \">\r\n" + 
				"<table>\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"From date : \r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<input type=\"date\" name=\"fromdate\" value=\"fromdate1\">\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"to date : \r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" + 
				"<input type=\"date\" name=\"todate\" value=\"todate1\">\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"\r\n" + 
				"<tr>\r\n" + 
				"<td><input type=\"submit\" name=\"submit\" value=\"get transactions\"></td>\r\n" + 
				"</tr>\r\n" + 
				"\r\n" + 
				"</table>\r\n" + 
				"</form>\r\n" + 
				"	<div id=\"transsum\">\r\n" + 
				"		<iframe name=\"transfrm\" width=\"800px\" height=\"300px\" src=\"view/createAccount.html\"></iframe>\r\n" + 
				"	\r\n" + 
				"	</div>" +
				"</body>\r\n" + 
				"</html>");
		
		
		
	}

}
