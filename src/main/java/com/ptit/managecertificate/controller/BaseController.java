package com.ptit.managecertificate.controller;

import org.springframework.ui.Model;

import com.ptit.managecertificate.utils.ErrorMessage;

public class BaseController {
	public void setUserLogin(Model model) {
		
		System.out.println("**** Show Error Msg Dialog ***");
		ErrorMessage errorMessage = new ErrorMessage();
		
	}
}
