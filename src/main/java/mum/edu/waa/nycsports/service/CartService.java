package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.Cart;

public interface CartService {
	
	Cart create(Cart cart);
	
	Cart read(String cartId);
	
	void update(String cartId, Cart cart);
	
	void delete(String cartId);

}
