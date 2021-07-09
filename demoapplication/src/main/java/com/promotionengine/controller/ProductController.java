package com.promotionengine.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.promotionengine.model.Product;
import com.promotionengine.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@GetMapping("/all")
	public String getAllProducts(Model model) {
		
		
		model.addAttribute("products",productService.getAllProducts());
		return "product_all";
	}
	
	@GetMapping("/{productId}")
	public String getProductId(Model model, @PathVariable("productId") int productId) {
		model.addAttribute("product",productService.getProductById(productId));
		return "product";
		
	}
	
	
	

}
