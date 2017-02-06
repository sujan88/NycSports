package mum.edu.waa.nycsports.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.Cart;

@Repository
public interface CartRepository extends  CrudRepository<Cart,String>{


}
