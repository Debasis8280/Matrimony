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
import mm.model.Dao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/mm.controller.Register2")
public class Register2 extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					System.out.println("===========Register2==============");
					String gender=request.getParameter("gender");
					System.out.println(gender);
					String mobile_no=request.getParameter("mobile");
					System.out.println(mobile_no); 
					String religion=request.getParameter("religion");
					System.out.println(religion);
					String mother_tongue=request.getParameter("mothertongue");
					System.out.println(mother_tongue); String
					country_living_in=request.getParameter("country");
					HttpSession session1=request.getSession();
					session1.setAttribute("country", country_living_in);
					System.out.println(country_living_in);
					
					HttpSession session=request.getSession();
					String email=(String)session.getAttribute("email");
					
					System.out.println("Register2.java \t"+email);
				User u=new User();
				u.setEmail_id(email);
				u.setGender(gender);
				u.setMobile_no(mobile_no);
				u.setReligion(religion);
				u.setMother_tongue(mother_tongue);
				u.setCountry_living_in(country_living_in);

				int status = Dao.insertUser2(u);
				if (status>0) {
					response.sendRedirect("registerReligionDetails.jsp#register-popup");
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
