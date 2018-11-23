package org.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mainservlet
 */
@WebServlet("/mainservlet")
public class mainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
	  PrintWriter out=response.getWriter();
	  out.println("<html>\r\n" + 
	  		"<head>\r\n" + 
	  		"<meta charset=\"ISO-8859-1\">\r\n" + 
	  		"<title>CapgBanking</title>\r\n" + 
	  		"<link type=\"text/css\" rel=\"stylesheet\" href=\"./styles/mainStyles.css\">\r\n" + 
	  		"</head>\r\n" + 
	  		"<body>\r\n" + 
	  		"\r\n" + 
	  		"<div id=\"mainCnt\">\r\n" + 
	  		"	<h2 align=\"center\">CapgBanking Process</h2>\r\n" + 
	  		"	<hr>\r\n" + 
	  		"	\r\n" + 
	  		"	<ul>\r\n" + 
	  		"		<li><a href=\"view/createAccount.html\" target=\"mainfrm\">Create Account</a></li>\r\n" + 
	  		"		<li><a href=\"Depositwithdrawservlet\" target=\"mainfrm\">Deposit/withdraw</a></li>\r\n" + 
	  		"		<li><a href=\"fundtransferservlet\" target=\"mainfrm\">Fund Transfer</a></li>\r\n" + 
	  		"		<li><a href=\"transsumservlet\" target=\"mainfrm\">Transaction Summary</a></li>\r\n" + 
	  		"		<li><a href=\"#\">Logout</a></li>\r\n" + 
	  		"	\r\n" + 
	  		"	</ul>\r\n" + 
	  		"	\r\n" + 
	  		"	<div>\r\n" +  session.getAttribute("myuser") +
	  		"	\r\n" + 
	  		"	</div>\r\n" + 
	  		"	\r\n" + 
	  		"	<div id=\"ctrCnt\">\r\n" + 
	  		"		<iframe name=\"mainfrm\" width=\"800px\" height=\"300px\" src=\"view/titlePage.html\"></iframe>\r\n" + 
	  		"	\r\n" + 
	  		"	</div>\r\n" + 
	  		"	\r\n" + 
	  		"	\r\n" + 
	  		"	\r\n" + 
	  		"<div id=\"footer\">\r\n" + 
	  		"<div style=\"float:left;padding-left: 10px;\">CapgBanking</div>\r\n" + 
	  		"<div style=\"margin-left:650px;\">Capg-FLP-2018</div>\r\n" + 
	  		"</div>\r\n" + 
	  		"</div>\r\n" + 
	  		"\r\n" + 
	  		"</body>\r\n" + 
	  		"</html>");
	  
	}

}
