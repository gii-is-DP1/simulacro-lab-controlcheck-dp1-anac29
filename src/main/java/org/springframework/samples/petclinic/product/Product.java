package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;

import org.springframework.data.annotation.Transient;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends NamedEntity {
    
	
	
	
	@Min(0)
    double price;
	
	@ManyToOne
    ProductType productType;
}
