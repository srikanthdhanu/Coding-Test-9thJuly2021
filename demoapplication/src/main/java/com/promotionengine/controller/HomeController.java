package com.promotionengine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String productDetails() {
		System.out.println("In home page");
		return "home";
	}

}
