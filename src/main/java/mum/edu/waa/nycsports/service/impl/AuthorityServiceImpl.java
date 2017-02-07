package mum.edu.waa.nycsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.Authority;
import mum.edu.waa.nycsports.repository.AuthorityRepository;
import mum.edu.waa.nycsports.service.AuthorityService;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public void addCustomer(String username) {
		Authority authority = new Authority();
		authority.setUsername(username);
		authority.setAuthority("ROLE_USER");
		authorityRepository.save(authority);
	}

	@Override
	public void addAdmin(String username) {
		Authority authority = new Authority();
		authority.setUsername(username);
		authority.setAuthority("ROLE_ADMIN");
		authorityRepository.save(authority);
	}

}
