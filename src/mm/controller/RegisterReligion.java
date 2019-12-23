package mm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.RegisterReligionDetails;
import mm.db.User;
import mm.model.Dao;

/**
 * Servlet implementation class RegisterReligion
 */
@WebServlet("/mm.controller.RegisterReligion")
public class RegisterReligion extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				System.out.println("=============Religion===============");
				String cast=request.getParameter("cast");
				System.out.println(cast);
				String subcast=request.getParameter("subcast");
				System.out.println(subcast);
				String gothra=request.getParameter("gothram");
				System.out.println(gothra);
				String dosh_no_yes_dontknow=request.getParameter("dosh");
				System.out.println(dosh_no_yes_dontknow);
				String dosh_yes_manglik=request.getParameter("manglik");
				System.out.println(dosh_yes_manglik);
				String dosh_yes_sarpadosh=request.getParameter("sarpadosh");
				System.out.println(dosh_yes_sarpadosh);
				String dosh_yes_kalasarapsosh=request.getParameter("Kalasarapsosh");
				System.out.println(dosh_yes_kalasarapsosh);
				String dosh_yes_rahudosh=request.getParameter("rahudosh");
				System.out.println(dosh_yes_rahudosh);
				String dosh_yes_kethudosh=request.getParameter("Kethudosh");
				System.out.println(dosh_yes_kethudosh);
				String dosh_yes_kalathradosh=request.getParameter("kalathradosh");
				System.out.println(dosh_yes_kalathradosh);
				
				HttpSession session=request.getSession();
				String email=(String)session.getAttribute("email");
				User u=new User();
				u.setEmail_id(email);
				
				RegisterReligionDetails rr=new RegisterReligionDetails();
				rr.setCast(cast);
				rr.setSubcast(subcast);
				rr.setGothra(gothra);
				rr.setDosh_no_yes_dontknow(dosh_no_yes_dontknow);
				rr.setDosh_yes_manglik(dosh_yes_manglik);
				rr.setDosh_yes_sarpadosh(dosh_yes_sarpadosh);
				rr.setDosh_yes_kalasarapsosh(dosh_yes_kalasarapsosh);
				rr.setDosh_yes_rahudosh(dosh_yes_rahudosh);
				rr.setDosh_yes_kethudosh(dosh_yes_kethudosh);
				rr.setDosh_yes_kalathradosh(dosh_yes_kalathradosh);
				
				int status=Dao.insertRegisterReligion(rr,u);
				if (status>0) {
					response.sendRedirect("registerPersonalDetails.jsp#register-popup");
				}
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
