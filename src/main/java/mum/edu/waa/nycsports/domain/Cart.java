package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2808280328830326032L;
	@Id
	private String cartId;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<CartItem> cartItems;
	private BigDecimal grandTotal;
	
	public Cart() {
		cartItems = new ArrayList< CartItem>();
		grandTotal = new BigDecimal(0);
	}
	
	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}
	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public  List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems( List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	
	public void addCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();
		
//		if(cartItems.a(productId)) {
//			CartItem existingCartItem = cartItems.get(productId);
//			existingCartItem.setQuantity(existingCartItem.getQuantity()+ item.getQuantity());
//			cartItems.put(productId, existingCartItem);
//		} else {
//			cartItems.put(productId, item);
//		}
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateGrandTotal();
	}
	
	public void updateGrandTotal() {
		grandTotal= new BigDecimal(0);
		for(CartItem item : cartItems){
			grandTotal = grandTotal.add(item.getTotalPrice());
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 71;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		return true;
	}
}
