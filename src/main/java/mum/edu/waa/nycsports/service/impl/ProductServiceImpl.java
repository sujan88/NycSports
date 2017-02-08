package mum.edu.waa.nycsports.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.repository.ProductRepository;
import mum.edu.waa.nycsports.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products= (List<Product>) productRepository.findAll();
		
		return products;
	}

	public Product getProductById(String productID) {
		return productRepository.findOne(productID);
	}
	
	public List<Product> getProductsByCategory(String category) {
		//return productRepository.getProductsByCategory(category);
		return null;
	}

//	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
//		return productRepository.getProductsByFilter(filterParams);
//	}
	
	public void addProduct(Product product) {
		   productRepository.save(product);
	}
	
	//find the newest products
	public List<Product> findProductsByDate(){
		return productRepository.findProductsByDate();
	}
	
	//find the products by price
	public List<Product> findProductsByPrice(){
		return productRepository.findProductsByPrice();
	}

}
