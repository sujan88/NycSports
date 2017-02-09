package mum.edu.waa.nycsports.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class Orders implements Serializable{

	private static final long serialVersionUID = 3560539622417210365L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Transient
	private Cart cart;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Customer customer;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private ShippingDetail shippingDetail;
	
	@Transient
	private CreditCard creditCard ;
	


	public Orders() {
		this.customer = new Customer();
		this.shippingDetail = new ShippingDetail();
		this.creditCard = new CreditCard();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public ShippingDetail getShippingDetail() {
		return shippingDetail;
	}



	public void setShippingDetail(ShippingDetail shippingDetail) {
		this.shippingDetail = shippingDetail;
	}



	public CreditCard getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
