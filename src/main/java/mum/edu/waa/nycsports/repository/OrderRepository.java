package mum.edu.waa.nycsports.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {

}
