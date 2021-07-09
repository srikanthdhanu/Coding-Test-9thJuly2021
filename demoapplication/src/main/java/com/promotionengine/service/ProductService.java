package com.promotionengine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.promotionengine.model.Product;

@Service
public class ProductService {
	
	public List<Product> getAllProducts() {
		ArrayList<Product> allProducts = new ArrayList<>();
		// Load from data base
		allProducts.add(new Product(100, "A", 50));
		allProducts.add(new Product(101, "B", 30));
		allProducts.add(new Product(102, "C", 20));
		allProducts.add(new Product(103, "D", 15));
		
		return allProducts;
	}
	
	public Product getProductById(int id) {
		Predicate<Product> byId=p ->p.getId()==id;
		return filterProducts(byId);
	}

	public Product filterProducts(Predicate<Product> strategy) {
		// TODO Auto-generated method stub
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}
	
	public Product getProductAmount(int id) {
		Predicate<Product> byId=p ->p.getId()==id;
		return filterProductAmount(byId);
	}
	public Product filterProductAmount(Predicate<Product> strategy) {
		// TODO Auto-generated method stub
		return getAllProducts().stream().filter(strategy).reduce((first, second) -> second).orElse(null);
	}
	
	
}
