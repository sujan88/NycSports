package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.Orders;

public interface OrderService {
	
	void processOrder(String  productId, long quantity);
	
	Long saveOrder(Orders order);
}
