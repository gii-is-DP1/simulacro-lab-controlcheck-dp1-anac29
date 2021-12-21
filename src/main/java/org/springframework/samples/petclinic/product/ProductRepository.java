package org.springframework.samples.petclinic.product;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product,Integer>{
	List<Product> findAll();
   
    
	@Query("SELECT pt from ProductType pt")
    List<ProductType> findAllProductTypes();
	@Query("SELECT pt FROM ProductType pt where pt.name=:name")
    ProductType findPTByName(@Param("name") String name);
	@Query("SELECT p FROM Product p where p.price<:price")
	List<Product> findByPriceLessThan(@Param("price") Double price);
    Product findByName(String name);
    Optional<Product> findById(int id);
    Product save(Product p);

}
