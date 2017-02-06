package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3682277381458553346L;
	@Id
	private int id;
	
	@OneToOne
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(Product product) {
		super();
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getUnitPrice();
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
		this.updateTotalPrice();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}
	
	@Override
	public int hashCode() {
		final int prime = 311;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}
