package mm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.RegisterAboutDetails;
import mm.db.User;
import mm.model.Dao;

/**
 * Servlet implementation class RegisterAbout
 */
@WebServlet("/mm.controller.RegisterAbout")
public class RegisterAbout extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
				String about=request.getParameter("about");
				 RegisterAboutDetails ra=new RegisterAboutDetails();
				 ra.setAbout(about);
				 HttpSession session=request.getSession();
				 String email=(String)session.getAttribute("email");
				 User u=new User();
				 u.setEmail_id(email);
				 int status=Dao.insertAbout(ra,u);
				 if (status>0) {
					response.sendRedirect("CompliteProfile.jsp");
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
