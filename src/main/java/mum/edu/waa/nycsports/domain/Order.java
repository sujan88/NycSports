package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "purchaseOrder")

public class Order implements Serializable {
	
	private static final long serialVersionUID = 5784L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private String orderNumber;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items = new ArrayList<OrderItem>();

	@OneToOne
	private OrderPayment payments;
	
	@ManyToOne
	private User customer;

	
	public Order(){}
	public Order(String orderNumber, List<OrderItem> items, OrderPayment payments) {

		this.orderNumber = orderNumber;
		this.items = items;
		this.payments = payments;
	}



	public void setPayments(OrderPayment payments) {
		this.payments = payments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.items.add(orderItem);
		orderItem.setOrder(this);
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}

}
