/**
 * @autor pathmasri
 * Nov 22, 2015 7:07:32 PM
 */
package com.ambegodas.backend.service.util;

import java.util.ArrayList;
import java.util.List;

import com.ambegodas.backend.model.Product;

public class ProductList {

	 private List<Product> products = new ArrayList<Product>();

	    public List<Product> getProducts() {
	        return products;
	    }

	    public void setProducts(List<Product> products) {
	        this.products = products;
	    }
}
