package mum.edu.waa.nycsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.UserCredentials;
import mum.edu.waa.nycsports.repository.UserCredentialRepository;
import mum.edu.waa.nycsports.service.UserCredentialService;

@Service
@Transactional
public class UserCredentialImpl implements UserCredentialService{

	@Autowired
	UserCredentialRepository userCredentialRepository;
	
	@Override
	public UserCredentials findOne(String username) {
		return (UserCredentials) userCredentialRepository.findOne(username);
	}

	@Override
	public void addCustomer(UserCredentials user) {
		user.setEnabled(true);
		userCredentialRepository.save(user);
	}
}
