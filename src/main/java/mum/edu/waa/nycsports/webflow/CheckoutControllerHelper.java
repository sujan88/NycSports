package mum.edu.waa.nycsports.webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mum.edu.waa.nycsports.domain.Cart;
import mum.edu.waa.nycsports.domain.Order;
import mum.edu.waa.nycsports.service.CartService;
import mum.edu.waa.nycsports.service.OrderService;


@Component
public class CheckoutControllerHelper {

	@Autowired
	OrderService orderService;
	@Autowired
	CartService cartService;
	
	public Long saveOrder(Order order) {
		return orderService.saveOrder(order);
	}
	
	public Cart validateCart(String cartId) {
		
		return cartService.validate(cartId);
		
	}
	
}
