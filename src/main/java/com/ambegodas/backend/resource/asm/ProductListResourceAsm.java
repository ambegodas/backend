/**
 * @autor pathmasri
 * Nov 22, 2015 7:05:52 PM
 */
package com.ambegodas.backend.resource.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.ambegodas.backend.controller.ProductController;
import com.ambegodas.backend.resource.ProductListResource;
import com.ambegodas.backend.service.util.ProductList;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ProductListResourceAsm  extends ResourceAssemblerSupport<ProductList,ProductListResource> {

	public ProductListResourceAsm() {
        super(ProductController.class, ProductListResource.class);
    }

	/* (non-Javadoc)
	 * @see org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object)
	 */
	public ProductListResource toResource(ProductList productList) {
		ProductListResource productListResource = new ProductListResource();
        productListResource.setProducts(productList.getProducts());

        Link link = linkTo(methodOn(ProductController.class).getProducts()).withSelfRel();
        productListResource.add(link);
        return productListResource;
	}

   
	
}
