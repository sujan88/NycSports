package mum.edu.waa.nycsports.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import mum.edu.waa.nycsports.domain.Product;


public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productID);
	
	List<Product> getProductsByCategory(String category);

//	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);

	void deleteProduct(String id);
	
	//newest products
	List<Product> findProductsByDate();
	
	//lowest price products
	List<Product> findProductsByPrice();
}
