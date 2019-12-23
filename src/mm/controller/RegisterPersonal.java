package mm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.RegisterPersonalDetails;
import mm.db.User;
import mm.model.Dao;

/**
 * Servlet implementation class RegisterPersonal
 */
@WebServlet("/mm.controller.RegisterPersonal")
public class RegisterPersonal extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("================RELIGION DETAIL================");
			String marital_status=request.getParameter("maritalstatus");
			System.out.println(marital_status);
			String marital_status_numberofchildren=request.getParameter("children");
			System.out.println(marital_status_numberofchildren);
			String marital_status_with_or_not=request.getParameter("childrenwith");
			System.out.println(marital_status_with_or_not);
			String height=request.getParameter("height");
			System.out.println(height);
			String family_status=request.getParameter("Family_Status");
			HttpSession session1=request.getSession();
			session1.setAttribute("familystatus", family_status);
			System.out.println(family_status);
			String family_type=request.getParameter("familytype");
			HttpSession session3=request.getSession();
			session3.setAttribute("familytype", family_type);
			System.out.println(family_type);
			String family_values=request.getParameter("Family_Values");
			HttpSession session2=request.getSession();
			session2.setAttribute("familyvalues", family_values);
			System.out.println(family_values);
			String any_disability=request.getParameter("disability");
			System.out.println(any_disability);
			RegisterPersonalDetails rp=new RegisterPersonalDetails();
			rp.setMarital_status(marital_status);
			rp.setMarital_status_numberofchildren(marital_status_numberofchildren);
			rp.setMarital_status_with_or_not(marital_status_with_or_not);
			rp.setHeight(height);
			rp.setFamily_status(family_status);
			rp.setFamily_type(family_type);
			rp.setFamily_values(family_values);
			rp.setAny_disability(any_disability);
			
			HttpSession session=request.getSession();
			String email=(String)session.getAttribute("email");
			
			User u=new User();
			u.setEmail_id(email);
			int status=Dao.insertPersonalDetail(rp,u);
			if (status>0) {
				response.sendRedirect("registerProfessionalDetails.jsp#register-popup");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
