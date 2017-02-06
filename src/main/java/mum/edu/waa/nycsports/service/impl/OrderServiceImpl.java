package mum.edu.waa.nycsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.repository.ProductRepository;
import mum.edu.waa.nycsports.service.OrderService;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository;
	
	public void processOrder(String productId, long quantity) {
		Product productById = productRepository.findOne(productId);
		
		if(productById.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
}
