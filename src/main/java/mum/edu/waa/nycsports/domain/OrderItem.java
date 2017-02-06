package mum.edu.waa.nycsports.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private int quantity;

	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	public OrderItem() {
		
	}
	
	public OrderItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	@ManyToOne
	private Order order;


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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}