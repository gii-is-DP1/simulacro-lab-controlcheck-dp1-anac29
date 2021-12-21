package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
	
	private ProductService productService;
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "products/createProduct";

	
	@Autowired
	public ProductController(ProductService productService, UserService userService, AuthoritiesService authoritiesService) {
		this.productService = productService;
	}
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	
	@GetMapping(value = "/products/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		List<ProductType> pts= productService.get
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/products/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			//creating owner, user and authorities
			this.productService.save(product);
			
			return "redirect:/products/create";
		}
	}
}
