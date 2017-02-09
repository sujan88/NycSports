package mum.edu.waa.nycsports.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mum.edu.waa.nycsports.domain.Cart;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.service.CartService;
import mum.edu.waa.nycsports.service.ProductService;


@Controller
@RequestMapping(value = "rest/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		return  cartService.create(cart);
	}

 	@RequestMapping(value = "/add/{productId}/{quantity}", method = RequestMethod.PUT ,headers = "Accept=application/json")
 	@ResponseStatus(value = HttpStatus.NO_CONTENT)
 	public void addItem(@PathVariable String productId,@PathVariable String quantity, HttpServletRequest request) throws Exception{
 
 	    int qty = Integer.parseInt(quantity);
		String sessionId = request.getSession(true).getId();

		Cart cart = cartService.read(sessionId);
		if(cart== null)
		{
			cart = cartService.create(new Cart(sessionId));
		}

		 cartService.update(productId, qty, cart);
		
		
	}
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String productId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
				
		cartService.removeCartItem(productId, cart);
	}
	
		@RequestMapping(value="/showProduct")
		public @ResponseBody  Product  getRestProduct ( @RequestParam("id") String productId  ) {

			Product product = productService.getProductById(productId);
	 		return product ;
		}

		
		@RequestMapping(value = "/getId", method = RequestMethod.GET)
		public @ResponseBody String getCartId(HttpSession session) {
			return session.getId();
		}

		// TODO:
		@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
		public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
	 		Cart cart= cartService.read(cartId);
	 
			return cart;
		}


		@RequestMapping("/mini")
		public String getMini(HttpServletRequest request) {
			return "redirect:/rest/cart/minicart/"+request.getSession(true).getId();
		}
		@RequestMapping(value = "/minicart/{cartId}", method = RequestMethod.GET )
		public @ResponseBody Cart getMiniCart(@PathVariable(value = "cartId") String cartId) {

			
			Cart cart = cartService.read(cartId);
			if (cart == null) {
				cart = new Cart(cartId);
				cartService.create(cart );
			}
			
			System.out.println(cart.getGrandTotal());
			return cart;
		}
		

	
	
}
