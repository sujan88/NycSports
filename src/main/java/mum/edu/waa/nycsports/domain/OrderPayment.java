package mum.edu.waa.nycsports.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class OrderPayment implements Serializable {
	private static final long serialVersionUID = 5784L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private Integer paymentNumber;

	@Column(length = 4)
	private String paymentType;

	@Column
	private Integer amount;

	public OrderPayment(){
		
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

	public Integer getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
	
}
