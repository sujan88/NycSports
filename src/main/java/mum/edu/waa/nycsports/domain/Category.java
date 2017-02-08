package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;



@Entity
public class Category implements Serializable{


	private static final long serialVersionUID = -2198868030961816984L;

	@Id
	String name;
	
	String description;

	// If using a List INSTEAD of a SET - less efficient
	@OneToMany(fetch=FetchType.EAGER)
	Set<Product> items = new HashSet<Product>();

	public Category() {
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getItems() {
		return items;
	}

	public void setItems(Set<Product> items) {
		this.items = items;
	}

	public void addItem(Product item) {
		this.items.add(item);

	}
}
