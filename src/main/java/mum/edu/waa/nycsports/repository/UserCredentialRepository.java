package mum.edu.waa.nycsports.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.UserCredentials;

@Repository
public interface UserCredentialRepository extends CrudRepository<UserCredentials, String>{

}
