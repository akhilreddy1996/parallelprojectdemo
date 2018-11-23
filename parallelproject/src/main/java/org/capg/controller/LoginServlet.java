package org.capg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capg.model.LoginBean;
import org.capg.service.ILoginService;
import org.capg.service.LoginServiceImpl;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ILoginService loginService=new LoginServiceImpl();
		
		//Capture the data from View
		String userName=req.getParameter("userName");
		String userPwd=req.getParameter("userPwd");
	
		
		//Convert the input into Model
		LoginBean login=new LoginBean();
		login.setUserName(userName);
		login.setUserPassword(userPwd);
		
		
		//Call Your business Logic
		//Navigate to next page
		if(loginService.isValidLogin(login))
		//	req.getRequestDispatcher("success").forward(req, resp);
		{
			HttpSession session=req.getSession();
		session.setAttribute("myuser", userName);
		
		
			req.getRequestDispatcher("mainservlet").include(req, resp);
		}
			//	resp.sendRedirect("");
		else
			//req.getRequestDispatcher("index.html").forward(req, resp);
			req.getRequestDispatcher("index.html").include(req, resp);
			//resp.sendRedirect("index.html");
		
		
	}

	
	
}
