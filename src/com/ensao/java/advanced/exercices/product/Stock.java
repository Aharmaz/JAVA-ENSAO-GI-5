package com.ensao.java.advanced.exercices.product;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stock extends TreeSet<Product> {

	public Stock() {
		super(COMPARATOR);
	}
	private static final ProductComparator COMPARATOR = new ProductComparator();
	
	public Stock filter(Predicate<Product> predicate) {
		var result = this.stream()
				.filter(predicate)
				.collect(Collectors.toCollection(Stock::new));
		return result;
		//throw new ToBeCompletedException("Return a Stock instance containing products " + "to which is applied the predicate");
	}


	public void discount(Discount discount, double amount) {
		Consumer<Product> consumer = product -> discount.discount(product, amount);
		this.stream()
				.forEach(consumer);
		//throw new ToBeCompletedException("apply a discount function " +" do not apply discount if discount amount is > 1 or < 0");
	}
	
	public <R> Collection<R> map(Function<Product, R> mapper) {
		var result = this.stream()
				.map(mapper)
				.collect(Collectors.toSet());
		return result;
		//throw new ToBeCompletedException("Retrun a collection of mapped property " +"of type 'R' of a product");
	}
	
	public void print(ProductPrinter printer) {
		this.stream()
				.forEach(printer::print);
		//throw new ToBeCompletedException("using the 'printer', print the products in this stock");
	}
	
	public Map<String, List<Product>> groupByCategory() {
		var result = this.stream()
				.collect(Collectors.groupingBy(Product::getCategory));
		return result;
		//throw new ToBeCompletedException("Retrun a map of a stock of products grouped by the category");
		
	}
	
	public Optional<Product> findProduct(String name) {


		var result = stream()
				.filter(product -> product.getName().equals(name))
				.findFirst();

		return result;

		//throw new ToBeCompletedException("Look for a product having the name 'name' if found");
	}
	
	public Stock moreExpensiveThan(Product product) {
		var result = this.stream()
				.filter(pd -> pd.getPrice() > product.getPrice())
				.collect(Collectors.toCollection(Stock::new));
		return result;

		//throw new ToBeCompletedException("return a new Stock of products" + " that are more expensive that a given product");
	}
	
	public Collection<Product> sorted() {
		return stream()
				.sorted(COMPARATOR)
				.collect(Collectors.toList());
	}
}
