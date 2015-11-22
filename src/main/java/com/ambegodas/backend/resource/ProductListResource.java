/**
 * @autor pathmasri
 * Nov 22, 2015 7:04:43 PM
 */
package com.ambegodas.backend.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.ambegodas.backend.model.Product;

public class ProductListResource extends ResourceSupport {

	 private List<Product> products = new ArrayList<Product>();

	    public List<Product> getProducts() {
	        return products;
	    }

	    public void setProducts(List<Product> products) {
	        this.products = products;
	    }
}
