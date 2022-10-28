package com.ensao.java.advanced.exercices.product;

public class Product extends AbstractProduct {
	
	@Override
	public Product clone() throws CloneNotSupportedException {

		Product product = new Product();
		product.setId(this.getId());
		product.setCategory(this.getCategory());

		return product;


	}

	public Product() {

	}
	
	
}