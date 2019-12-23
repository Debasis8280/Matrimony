package mm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MatchOTP
 */
@WebServlet("/mm.controller.MatchOTP")
public class MatchOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("===========Enter OTP==========");
		HttpSession session=request.getSession();
		String sessionotp=(String)session.getAttribute("sessionotp");
		String otp=request.getParameter("otp");
		System.out.println(otp);
		System.out.println(sessionotp);
		if (otp.equalsIgnoreCase(sessionotp)) 
		{
			response.sendRedirect("forgotpassword.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	}

}
