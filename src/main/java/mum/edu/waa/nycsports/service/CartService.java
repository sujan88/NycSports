package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.Cart;
import mum.edu.waa.nycsports.domain.CartItem;

public interface CartService {
	
	Cart create(Cart cart);
	
	Cart read(String cartId);
	
	Cart update(String productId, int quantity,  Cart cart);
	
	Cart removeCartItem(String cartItemId, Cart cart);
	
	void delete(String cartId);

	Cart validate(String cartId);
	


}
