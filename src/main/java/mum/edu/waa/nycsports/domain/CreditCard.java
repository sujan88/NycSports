package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CreditCard implements Serializable{

	private static final long serialVersionUID = 6350930334140807514L;
	
	@Id
	private Integer number;

	private String name;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date expiryDate;
	private Address billingAddress;

	
		public CreditCard() {
		this.billingAddress = new Address();
	}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Date getExpiryDate() {
			return expiryDate;
		}


		public void setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate;
		}


		public Address getBillingAddress() {
			return billingAddress;
		}


		public void setBillingAddress(Address billingAddress) {
			this.billingAddress = billingAddress;
		}


		public Integer getNumber() {
			return number;
		}


		public void setNumber(Integer number) {
			this.number = number;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
