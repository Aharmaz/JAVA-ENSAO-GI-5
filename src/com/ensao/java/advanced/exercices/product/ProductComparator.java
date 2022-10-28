package com.ensao.java.advanced.exercices.product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
	public final boolean byPrice;
	
	public ProductComparator() {
		this.byPrice = false;
	}
	
	public ProductComparator(boolean byPrice) {
		this.byPrice = byPrice;
	}
	
	@Override
	public int compare(Product productA, Product productB) {

		if (byPrice) {

			// pay attention to the implementation of this method

			return Comparator.comparing(Product::getPrice).compare(productA, productB);
		}
		return Comparator.comparing(Product::getName).compare(productA, productB);
		//return productA.getName().compareTo(productB.getName());

		//throw new ToBeCompletedException("if 'byPrice' is false compare products using their names," + " use the price otherwise");
	}
}
