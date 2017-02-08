package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class ShippingDetail implements Serializable{

	private static final long serialVersionUID = 6350930334140807514L;
	@Id
 	private String name;

	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
 	private Address shippingAddress;

	@Valid
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date shippingDate;
	
	
		public ShippingDetail() {
		this.shippingAddress = new Address();
	}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Date getShippingDate() {
			return shippingDate;
		}


		public void setShippingDate(Date shippingDate) {
			this.shippingDate = shippingDate;
		}


		public Address getShippingAddress() {
			return shippingAddress;
		}


		public void setShippingAddress(Address shippingAddress) {
			this.shippingAddress = shippingAddress;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
