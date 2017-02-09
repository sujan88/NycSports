package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.User;

public interface UserService {
	void addUser(User user);
	
	User getUserByUsername(String username);
}
