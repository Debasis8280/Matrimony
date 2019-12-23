package mm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.Provider;
import mm.db.User;
import mm.model.Check;
import mm.model.Dao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/mm.controller.Register")
public class Register extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				System.out.println("===========Register==============");
				String matrimony_profile_for=request.getParameter("profile");
				System.out.println(matrimony_profile_for);
				HttpSession session1=request.getSession();
				session1.setAttribute("profile", matrimony_profile_for);
				String name=request.getParameter("name");
				System.out.println(name);
				String email_id=request.getParameter("email");
				System.out.println(email_id);
				HttpSession session=request.getSession();
				session.setAttribute("email", email_id);
				String date_of_birth=request.getParameter("date");
				System.out.println(date_of_birth);
				String password=request.getParameter("password");
				System.out.println(password);
								
				User u=new User();
				u.setMatrimony_profile_for(matrimony_profile_for);
				u.setName(name);
				u.setEmail_id(email_id);
				u.setDate_of_birth(date_of_birth);
				u.setPassword(password);
				
				int status = Dao.insertUser1(u);
				if (status>0) {
					response.sendRedirect("register2.jsp#register-popup");
				}
				else
				{
					System.out.println("Back to Register Page");
					response.sendRedirect("register.jsp?msg=You Enter Exit Email!...#register-popup");
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
