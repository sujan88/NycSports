package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.UserCredentials;

public interface UserCredentialService {
	UserCredentials findOne(String username);
	void addCustomer(UserCredentials user);
}
