package com.ptit.managecertificate.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.managecertificate.entity.Role;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.UserModel;
import com.ptit.managecertificate.service.UserService;

@Controller
public class MainController extends BaseController {
	private static final Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "index";
	}

	
	// SIGN UP FOR USER
	@RequestMapping(value = "/signupUser", method = RequestMethod.GET)
	public String userPage(Model model) {
		setUserLogin(model);
		model.addAttribute("user", new UserModel());
		return "admin/signupUser";
	}
	
	@RequestMapping(value = "/signupUser", method = RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, Model model) {
		setUserLogin(model);
		if (userService.checkUserInDatabase(user)) {
			model.addAttribute("message", "User Name or Email exists. Try another user name or email");
			return "signup";
		} else {
			logger.info("Create User ===============>" + user.getUsername());

			
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

			Role r = new Role();
			r.setName("ROLE_USER");

			Set<Role> s = new HashSet<Role>();
			s.add(r);
			
			user.setRoles(s);
			
			userService.saveUser(user);

			model.addAttribute("message", "Saved User");
			return "success";
		}
	}
	
	//SIGN UP FOR ADMIN
	@RequestMapping(value = "/signupAdmin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		setUserLogin(model);
		model.addAttribute("user", new UserModel());
		return "admin/signupUser";
	}

	@RequestMapping(value = "/signupAdmin", method = RequestMethod.POST)
	public String signupAdmin(@ModelAttribute("user") User user, Model model) {
		setUserLogin(model);
		if (userService.checkUserInDatabase(user)) {
			model.addAttribute("message", "User Name or Email exists. Try another user name or email");
			return "admin/signupAdmin";
		} else {
			logger.info("Create Admin ===============>" + user.getUsername());

			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

			Role r = new Role();
			r.setName("ROLE_ADMIN");
			
			Set<Role> s = new HashSet<Role>();
			s.add(r);

			user.setRoles(s);
			
			userService.saveUser(user);

			model.addAttribute("message", "Saved User");
			return "success";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model, @RequestParam(value = "error", required = false) String error) {
		setUserLogin(model);
		model.addAttribute("user", new UserModel());
		logger.info("===============>" + error);
		if ("true".equalsIgnoreCase(error)) {
			return "failure";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		setUserLogin(model);
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}

	@RequestMapping(value = "/term", method = RequestMethod.GET)
	public String term(Model model) {
		return "TermAndCondition";
	}
	
	
}