package com.example.webbanhang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.webbanhang.dto.OrderDTO;
import com.example.webbanhang.service.impl.ProductServiceImpl;

@Controller

public class HomeController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("user", userDetails);
		model.addAttribute("list", productServiceImpl.getList());
		
		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			model.addAttribute("order", orderDTO);

		}
		return "home";
	}

}
