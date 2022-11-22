package com.ptit.managecertificate.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class BaseController {
	public void setUserLogin(Model model) {

		System.out.println("**** get user Login***");
		boolean loginStatus = SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
			model.addAttribute("loginstatus",loginStatus);
	}
}
