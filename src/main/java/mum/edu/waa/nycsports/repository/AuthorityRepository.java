package mum.edu.waa.nycsports.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long>{

}
