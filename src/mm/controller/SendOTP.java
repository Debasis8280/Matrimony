package mm.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mm.db.User;
import mm.model.Check;
import mm.model.Dao;

/**
 * Servlet implementation class SendOTP
 */
@WebServlet("/mm.controller.SendOTP")
public class SendOTP extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailTo=request.getParameter("email");
		String senderEmail="matrimonysitecse@gmail.com";
		String password="Matrimony2020";
		
		//send OTP
		int randomPin   =(int) (Math.random()*9000)+1000; 
        String otp  = String.valueOf(randomPin); 
        
        
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(props,new javax.mail.Authenticator()
				{
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(senderEmail, password);	
					}
				});
		User u=new User();
		u.setEmail_id(emailTo);
		
		
		try {
			int checkemail=Check.emailCheck(u);
			if (checkemail>0) 
			{
				Message message=new MimeMessage(session);
				message.setFrom(new InternetAddress("matrimonysitecse@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
				message.setSubject("OTP");
				message.setText("Your verification code is "+otp);
				Transport.send(message);
				System.out.println("Forgot Password Email Send");
				if (otp!=null) 
				{
					HttpSession session2=request.getSession();
					session2.setAttribute("sessionotp", otp);
					session2.setAttribute("email", emailTo);
					response.sendRedirect("matchOTP.jsp");
				}
				else
				{
					response.sendRedirect("error.jsp");
				}
			}
			else {
				response.sendRedirect("sendOTP.jsp?msg=You Enter Invalid Email...</p>");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
