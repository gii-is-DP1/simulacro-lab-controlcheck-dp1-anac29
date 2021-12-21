package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public ProductType getProductByName(String name){
        return null;
    }
    public List<Product> getProductsCheaperThan(double price) {
        return repo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return  repo.findPTByName(typeName);

    }

    public Product save(Product p){
        return null;       
    }

    
}
