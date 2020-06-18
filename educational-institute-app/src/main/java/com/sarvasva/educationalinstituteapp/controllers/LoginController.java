package com.sarvasva.educationalinstituteapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	
	public String getLogin(Model model) {
		
		return "login";
	}
	@GetMapping("/login-error")
	public String getLoginForFailure(HttpServletRequest request,Model model) {
		 	HttpSession session = request.getSession(false);
	        String errorMessage = null;
	        if (session != null) {
	            AuthenticationException ex = (AuthenticationException) session
	                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	            if (ex != null) {
	                errorMessage = ex.getMessage();
	            }
	        }
	        model.addAttribute("errorMessage", errorMessage);
	        return "login";
	}
	@GetMapping("/login-logout-success")
	public String getLoginForLogoutSuccess(Model model) {
		model.addAttribute("successLogoutMessage","You have been logged out");
		return "login";
	}
}
