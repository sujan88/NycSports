package mum.edu.waa.nycsports.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.waa.nycsports.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

	
	@Query("select p.productId from Product p")
	List<String> getProductsIds();
}
