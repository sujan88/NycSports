package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CreditCard implements Serializable{

	private static final long serialVersionUID = 6350930334140807514L;
	
	@Id
	@NotNull
	@Size(min=1111, max=9999, message="{Size}")
	private Integer number;
    @NotEmpty
	private String name;
    @Valid
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date expiryDate;
	
	private int cvv;
	
	
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

		public int getCvv() {
			return cvv;
		}


		public void setCvv(int cvv) {
			this.cvv = cvv;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
