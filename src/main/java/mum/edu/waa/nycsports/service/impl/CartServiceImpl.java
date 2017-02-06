package mum.edu.waa.nycsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.Cart;
import mum.edu.waa.nycsports.repository.CartRepository;
import mum.edu.waa.nycsports.service.CartService;


@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	public Cart create(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart read(String cartId) {
		return cartRepository.findOne(cartId);
	}

	public void update(String cartId, Cart cart) {
		cartRepository.save(cart);
	}

	public void delete(String cartId) {
		cartRepository.delete(cartId);
		
	}

}
