package mum.edu.waa.nycsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.Orders;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.repository.OrderRepository;
import mum.edu.waa.nycsports.repository.ProductRepository;
import mum.edu.waa.nycsports.service.CartService;
import mum.edu.waa.nycsports.service.OrderService;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartService cartService;

	
	public void processOrder(String productId, long quantity) {
		Product productById = productRepository.findOne(productId);
		
		if(productById.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
	

	
	public Long saveOrder(Orders order) {
		Orders o= orderRepository.save(order);
		cartService.delete(order.getCart().getCartId());
		return o.getId();
	}

}
