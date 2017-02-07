package mum.edu.waa.nycsports.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.CartItem;

@Repository
public interface CartItemRepository extends  CrudRepository<CartItem,Integer>{


}
