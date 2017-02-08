
package mum.edu.waa.nycsports.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name = "CREDENTIALS")
public class UserCredentials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -642245239272791341L;

	@Id
	@Column(nullable = false, unique = true)
	@NotEmpty
	String username;

	@Column(nullable = false)
	@Size(min=8, max=32, message="{Size.password}")
	@NotEmpty
	String password;

	String verifyPassword;

	Boolean enabled;

	@OneToOne(mappedBy = "userCredentials")
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "credentials_id")
	List<Authority> authority = new ArrayList<Authority>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isAdmin(){
		for (Authority auth : authority)
		{
			if (auth.getAuthority().equals("ROLE_ADMIN"))
				return true;
		}
		return false;
	}
	
	public boolean isUser(){
		for (Authority auth : authority)
		{
			if (auth.getAuthority().equals("ROLE_USER"))
				return true;
		}
		return false;
	}

}
