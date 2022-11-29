package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.Email.JavaEmail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController{
	   private static final Logger logger = Logger.getLogger(ContactController.class);
	   @RequestMapping(value = "/contact", method = RequestMethod.GET)
	   public String contacts(Model model) {
	       return "contact";
	   }
	   @RequestMapping(value = "/contact", method = RequestMethod.POST)
	   public String sendEMail(Model model,HttpServletRequest request) {
				JavaEmail javaEmail = new JavaEmail();
				javaEmail.setMailServerProperties();
				String emailSubject = "Support Email";
				String emailBody = "";
				if (request.getParameter("name") != null) {
					emailBody = "Sender Name: " + request.getParameter("name")
							+ "<br>";
				}
				if (request.getParameter("email") != null) {
					emailBody = emailBody + "Sender Email: "
							+ request.getParameter("email") + "<br>";
				}
				if (request.getParameter("phone") != null) {
					emailBody = emailBody + "Sender Phone: "
							+ request.getParameter("phone") + "<br>";
				}
				if (request.getParameter("message") != null) {
					emailBody = emailBody + "Message: " + request.getParameter("message")
							+ "<br>";
				}
				try {
					javaEmail.createEmailMessage(emailSubject, emailBody);
					javaEmail.sendEmail();
					model.addAttribute("status","success");
					model.addAttribute("message","Email sent Successfully!");
					logger.info("Email sent Successfully!");
				} catch (MessagingException me) {
					model.addAttribute("status","error");
					model.addAttribute("message","Error in Sending Email!");
					logger.info("Email send error: " + me.getMessage());
				}
		   return "contact";
	   }
}
