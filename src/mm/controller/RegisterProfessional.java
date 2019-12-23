package mm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.RegisterProefssionalDetails;
import mm.db.User;
import mm.model.Dao;

/**
 * Servlet implementation class RegisterProfessional
 */
@WebServlet("/mm.controller.RegisterProfessional")
public class RegisterProfessional extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				System.out.println("==============PROFESSIONAL DETAILS=================");
				String highest_education=request.getParameter("HighestEducation");
				System.out.println(highest_education);
				String employed_in=request.getParameter("Employed");
				System.out.println(employed_in);
				String occupation_status=request.getParameter("Occupation");
				System.out.println(occupation_status);
				String annual_income=request.getParameter("income");
				System.out.println(annual_income);
				String work_locationcountry=request.getParameter("worklocation");
				System.out.println(work_locationcountry);
				String work_locationcitizenship=request.getParameter("workCitizenship");
				System.out.println(work_locationcitizenship);
				String brides_locationcountry=request.getParameter("NotWorkingCountry");
				System.out.println(brides_locationcountry);
				String brides_currentcitizenship=request.getParameter("NotWorkingCitizenship");
				System.out.println(brides_currentcitizenship);
				
				HttpSession session=request.getSession();
				String email=(String)session.getAttribute("email");
				User u=new User();
				u.setEmail_id(email);
				
				RegisterProefssionalDetails rpf=new RegisterProefssionalDetails();
				rpf.setHighest_education(highest_education);
				rpf.setEmployed_in(employed_in);
				rpf.setOccupation_status(occupation_status);
				rpf.setAnnual_income(annual_income);
				rpf.setWork_locationcountry(work_locationcountry);
				rpf.setWork_locationcitizenship(work_locationcitizenship);
				rpf.setBrides_locationcountry(brides_locationcountry);
				rpf.setBrides_currentcitizenship(brides_currentcitizenship);
				int status=Dao.insertRegisterprofessional(rpf,u);
				if (status>0) {
					response.sendRedirect("registerAboutyou.jsp#register-popup");
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
