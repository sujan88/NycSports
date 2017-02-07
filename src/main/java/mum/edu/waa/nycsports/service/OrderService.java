package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.Order;

public interface OrderService {
	
	void processOrder(String  productId, long quantity);
	
	Long saveOrder(Order order);
}
