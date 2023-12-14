package com.example.webbanhang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControllerBE {

	@GetMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(name="e", required = false) String error) {
		if(error != null) {
			//change
			System.out.println("Error: ");
			request.setAttribute("e", error + "!!!");
		}
		return "login";
	}
	
}
