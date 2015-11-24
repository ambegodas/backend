/**
 * @autor pathmasri
 * Nov 22, 2015 7:01:31 PM
 */
package com.ambegodas.backend.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.ambegodas.backend.controller.ProductController;
import com.ambegodas.backend.model.Product;
import com.ambegodas.backend.resource.ProductResource;

public class ProductResourceAsm extends ResourceAssemblerSupport<Product, ProductResource> {

	public ProductResourceAsm (){
		super(ProductController.class,ProductResource.class);
	}
	
	public ProductResource toResource(Product product){
		
		ProductResource productResource = new ProductResource();
		productResource.setDescription(product.getDescription());
		productResource.setCode(product.getCode());
		productResource.setPrice(product.getPrice());
		//Link link = linkTo(methodOn(ProductController.class).getProduct(product.getCode())).withSelfRel(); productResource.add(link);
		return productResource;
	}
}
