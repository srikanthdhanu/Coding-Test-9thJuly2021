package com.promotionengine.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.promotionengine.model.Item;
import com.promotionengine.model.Product;
import com.promotionengine.service.ProductService;

@Controller
@RequestMapping("/shoppingcart")
public class MyCartController {
	@Autowired
	private ProductService productService;
	 Product product = new Product();
	
	@GetMapping("/ordernow/{productId}")
    public String ordernow(Model model, @PathVariable("productId") int productId, HttpSession session) {
  	 
  	  if(session.getAttribute("cart")==null)
  	  {
  		 List<Item> cart=new ArrayList<Item>();
  		 cart.add(new Item(this.productService.getProductById(productId), 1,this.productService.getProductAmount(productId)));
  		 session.setAttribute("cart", cart);
  		 int index=isExistingItem(productId, session);
  		 double productPrice=cart.get(index).getProduct().getPrice();
  		 cart.get(index).setPromotionPrice(productPrice);
  		
  	  }else {
  		 List<Item> cart=(List<Item>)session.getAttribute("cart");
  		 int index=isExistingItem(productId, session);
  		 if(index ==-1)
  		 {
  			 
  		 cart.add(new Item(this.productService.getProductById(productId), 1,this.productService.getProductAmount(productId)));
  		double productPrice=cart.get(cart.size()-1).getProduct().getPrice();
  		cart.get(cart.size()-1).setPromotionPrice(productPrice);
  		if(cart.get(cart.size()-1).getProduct().getName().equals("D") && cart.get(cart.size()-2).getProduct().getName().equals("C")) {
  			cart.get(cart.size()-2).setPromotionPrice(0.0);
  			cart.get(cart.size()-1).setPromotionPrice(30);
  		}
  		 }
  		 else {
  			 int quantity=cart.get(index).getQuantity()+1;
  			 cart.get(index).setQuantity(quantity);
  			 String productName=cart.get(index).getProduct().getName();
  			 double productPrice=cart.get(index).getProduct().getPrice();
  			 
  			 
  			 
  			 if(quantity >=3 && productName.equals("A"))
  			 {
  				 double promotionPrice=(quantity/3)*130+(quantity%3 * productPrice);
  				 cart.get(index).setPromotionPrice(promotionPrice);
  				
  				 
  			 }else if(quantity >=2 && productName.equals("B")) {
  				 double promotionPrice=(quantity/2)*45+(quantity%2 * productPrice);
  				 cart.get(index).setPromotionPrice(promotionPrice);
				} else 
					cart.get(index).setPromotionPrice(quantity*productPrice);
				
					 
  		 }
 		 session.setAttribute("cart", cart);
  	  }
  	  return "mycart";
    }
	
	private int isExistingItem(int id,HttpSession session) {
		List<Item> cart=(List<Item>)session.getAttribute("cart");
		
		for (int i=0;i<cart.size();i++) {
			if(cart.get(i).getProduct().getId() == id)
				return i;
		}
		return -1;
	}

}
