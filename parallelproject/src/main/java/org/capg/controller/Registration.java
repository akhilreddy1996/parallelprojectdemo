package org.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   PrintWriter out=response.getWriter();
   
   out.println("<!DOCTYPE html>\r\n" + 
   		"<html>\r\n" + 
   		"<head>\r\n" + 
   		"<meta charset=\"ISO-8859-1\">\r\n" + 
   		"<title>CapgBanking</title>\r\n" + 
   		"\r\n" + 
        "<style>\r\n" + 
        "\r\n" + 
        "form{\r\n" + 
        "		margin: 0;\r\n" + 
        "		\r\n" + 
        "}\r\n" + 
        "a{\r\n" + 
        "	\r\n" + 
        "	text-decoration: none;\r\n" + 
        "border: none;\r\n" + 
        "}\r\n" + 
        "\r\n" + 
        "a:link{\r\n" + 
        "\r\n" + 
        "	text-decoration: none;\r\n" + 
        "	border: none;\r\n" + 
        "\r\n" + 
        "}\r\n" + 
        "\r\n" + 
        "#register{\r\n" + 
        "	margin: 50px 100px 100px 50px;\r\n" + 
        "	border-radius: 25px;\r\n" + 
        "	border: 2px solid blue;\r\n" + 
        "	\r\n" + 
        "	\r\n" + 
        "}\r\n" + 
        "\r\n" + 
        ".tablecnt{\r\n" + 
        "	margin-left: 200px;\r\n" + 
        "}\r\n" + 
        "h2,th{\r\n" + 
        "	color:blue;\r\n" + 
        "}\r\n" + 
        "hr{\r\n" + 
        "	border-color: blue;\r\n" + 
        "}\r\n" + 
        ".btnStyle{\r\n" + 
        "	margin-top:10px;\r\n" + 
        "	padding:5px 5px 5px 5px;\r\n" + 
        "	width:100px;\r\n" + 
        "	background-color: blue;\r\n" + 
        "	color: white;\r\n" + 
        "	font-weight: bold;\r\n" + 
        "}\r\n" + 
        "\r\n" + 
        "</style>" +
" \r\n" + 
"<script type=\"text/javascript\">\r\n" + 
"\r\n" + 
"\r\n" + 
"\r\n" + 
"function validat()\r\n" + 
"{\r\n" + 
"	\r\n" + 
"var pw=f2.custPwd.value;\r\n" + 
"var cnfrmpw=f2.confimrCustPwd.value;\r\n" + 
"var dob=f2.dateOfbirth.value;\r\n" + 
"var parts=dob.split('-');\r\n" + 
"var todaydate=new Date();\r\n" +
"var inputdate=new Date(dob);\r\n" +
"\r\n" + 
"if(pw===cnfrmpw)\r\n" + 
"	{\r\n" + 
" if(inputdate>todaydate)\r\n" + 
"		  {\r\n" + 
"		  document.getElementById('passwordErrMsg').innerHTML=\"invalid input date\";\r\n" + 
 " return false;\r\n" +
"		  }\r\n" + 
"	  else\r\n" + 
"		  {\r\n" + 
"	  return  true;\r\n" + 
"		  }" +
"	}\r\n" + 
"else\r\n" + 
"	{\r\n" + 
"	document.getElementById('passwordErrMsg').innerHTML=\"*pw and cfrm pw doesnt match.\"  \r\n" + 
"  return false;\r\n" + 
"	}\r\n" + 
"\r\n" + 
"\r\n" + 
"}" + 
"\r\n" + 
"</script>" + 
         "" +
   		"\r\n" + 
   		"</head>\r\n" + 
   		"<body>\r\n" + 
   		"<form method=\"post\" action=\"register\" name=\"f2\" onsubmit=\"return validat()\" >\r\n" + 
   		"<div id=\"register\">\r\n" + 
   		"<h2 align=\"center\">Customer Registration Form</h2>\r\n" + 
   		"<hr>\r\n" + 
   		"	<div class=\"tablecnt\">\r\n" + 
   		"		<table >\r\n" + 
   		"			<tr>\r\n" + 
   		"				<th colspan=\"3\">Customer Form</th>\r\n" + 
   		"			</tr>\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>FirstName:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"text\" name=\"firstName\" size=\"20\" pattern=\"[A-Za-z]+\" title=\"First Name should be in alphabeticals\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>LastName:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"text\" name=\"lastName\" size=\"20\" pattern=\"[A-Za-z]+\" title=\"last Name should be in alphabeticals\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>DateOfBirth:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"date\" name=\"dateOfbirth\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>AddressLine1:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<textarea rows=\"3\" cols=\"25\" name=\"addressline1\" required=\"required\"></textarea>\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>AddressLine2:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<textarea rows=\"3\" cols=\"25\" name=\"addressline2\" required=\"required\"></textarea>\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>Choose City:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<select name=\"city\" required=\"required\">\r\n" + 
   		"						<option value=\"Chennai\">Chennai</option>\r\n" + 
   		"						<option value=\"Hyderabad\">Hyderabad</option>\r\n" + 
   		"						<option value=\"Pune\">Pune</option>\r\n" + 
   		"						<option value=\"Delhi\">Delhi</option>\r\n" + 
   		"						<option value=\"Mumbai\">Mumbai</option>\r\n" + 
   		"						\r\n" + 
   		"					</select>\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>Choose State:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"radio\" name=\"state\" value=\"TamilNadu\"> TamilNadu\r\n" + 
   		"					<input type=\"radio\" name=\"state\" value=\"Andra\"> Andra \r\n" + 
   		"					<input type=\"radio\" name=\"state\" value=\"UP\"> UP \r\n" + 
   		"					<input type=\"radio\" name=\"state\" value=\"Maharashtra\"> Maharashtra \r\n" + 
   		"					 \r\n" + 
   		"					\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>Pincode:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"text\" name=\"pincode\" size=\"20\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>EmailId:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"email\" name=\"email\" size=\"20\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>MobileNumber:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"text\" name=\"mobile\" size=\"20\" pattern=\"[7|8|9]{1}[0-9]{9}\" title=\"mobile no  should be in proper format\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>Password:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"password\" name=\"custPwd\" size=\"20\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"				<td>Confirm Password:</td>\r\n" + 
   		"				<td>\r\n" + 
   		"					<input type=\"password\" name=\"confimrCustPwd\" size=\"20\" required=\"required\">\r\n" + 
   		"				</td>\r\n" + 
   		"				<td>\r\n" + 
   		"				<div id=\"passwordErrMsg\" class=\"pwerrMsg\"></div>\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"			\r\n" + 
   		"			<tr>\r\n" + 
   		"			\r\n" + 
   		"				<td></td>\r\n" + 
   		"				<td>\r\n" + 
   		"				\r\n" + 
   		"					<input type=\"submit\" name=\"register\" value=\"Register\" class=\"btnStyle\">\r\n" + 
   		"				</td>\r\n" + 
   		"			</tr>\r\n" + 
   		"			\r\n" + 
   		"		</table>\r\n" + 
   		"	\r\n" + 
   		"	</div>\r\n" + 
   		"</div>\r\n" + 
   		"</form>\r\n" );
   		
        HttpSession session=request.getSession();
        
   		if(session.getAttribute("check").toString().compareTo("true")==0)
   		{
   			out.println("<h3>Record succesfully inserted</h3>");
   		}
   		out.println("\r\n" + 
   		"</body>\r\n" + 
   		"</html>"
   		);
		
		
	}

	
}
