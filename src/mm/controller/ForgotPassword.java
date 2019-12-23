package mm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.User;
import mm.model.Dao;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/mm.controller.ForgotPassword")
public class ForgotPassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			System.out.println("========Enter ForgetPasseord.java============");
			HttpSession session=request.getSession();
			String email=(String)session.getAttribute("email");
			System.out.println(email);
			String password=request.getParameter("password");
			System.out.println(password);
			User u=new User();
			u.setPassword(password);
			u.setEmail_id(email);
			int status=Dao.forgotPassword(u);
			if (status>0)
			{
				response.sendRedirect("forgotpassword.jsp?msg=Your Password Successfully Update...<br><button><a href='index.jsp'>Go To  Login Again..</a></button>#login-popup");
			}
			else
			{
				response.sendRedirect("erroe.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
