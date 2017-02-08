package mum.edu.waa.nycsports.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
