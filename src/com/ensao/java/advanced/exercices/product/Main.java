package com.ensao.java.advanced.exercices.product;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Product computer = new Product();
		computer.setId(1);
		computer.setName("Computers");
		computer.setPrice(400.00);
		computer.setCategory("IT");
		
		Stock stock = new Stock();
		var result = stock.sorted();
		stock.add(computer);
		Map<String, List<Product>> groupedByCategory = stock.groupByCategory();
		Collection<String> productsNamesOnly = stock.map(product -> product.getName());
		Object foundProduct = stock.findProduct("Computers").orElse(new Product());
		Discount discount = null; // to complete

		//stock.discount(discount);
		Stock expensiveThanComputer = stock.moreExpensiveThan(computer);
		
		Stock filtered = stock.filter(p -> p.getPrice() > 100); // to complete
		
		
	}
}
