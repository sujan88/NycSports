package mum.edu.waa.nycsports.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address implements Serializable{


	private static final long serialVersionUID = -5823921891587763555L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

 	private String street;
 	@NotEmpty(message="{NotEmpty}")
	private String city;
	@Size(min=2, max=2, message="{Size.state}")
 	private String state;

	@Pattern(regexp="[1-9]{5}",
	             message="{Invalid.zipCode}")
    private String zipCode;

	private String country;

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
  
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
