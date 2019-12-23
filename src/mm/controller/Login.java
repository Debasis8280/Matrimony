package mm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.User;
import mm.model.Dao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/mm.controller.Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				System.out.println("=================Login===================");
				String user=request.getParameter("email");
				System.out.println(user);
				String password=request.getParameter("password");
				System.out.println(password);
				HttpSession session=request.getSession();
				session.setAttribute("email", user);
				
				User u=new User();
				u.setEmail_id(user);
				u.setPassword(password);
				
				int status=Dao.checkLogin(u);
				if (status>0) 
				{
					response.sendRedirect("www.google.com");
				}
				else {
					response.sendRedirect("login.jsp?msg=Enter Invalid Email OR Password#login-popup");
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
