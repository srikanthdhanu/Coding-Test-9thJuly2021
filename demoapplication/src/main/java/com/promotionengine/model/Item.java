package com.promotionengine.model;

public class Item {

	private Product product= new Product();
	private int quantity;
	private Product product1= new Product();
	private double promotionPrice;
	
	public Product getProduct1() {
		return product1;
	}
	public void setProduct1(Product product1) {
		this.product1 = product1;
	}
	public double getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + "]";
	}
	
	public Item(Product product, int quantity, Product product1) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.product1 = product1;
	}
	
	
}
