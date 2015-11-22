/**
 * @autor pathmasri
 * Nov 22, 2015 6:26:05 PM
 */
package com.ambegodas.backend.service;

import com.ambegodas.backend.model.Product;
import com.ambegodas.backend.service.util.ProductList;

public interface ProductService {

	public Product getProduct(long productId);
	public Product updateProduct(Product product);
	public void deleteProduct(Product product);
	public Product addProduct(Product product);
	public ProductList getProducts();
	public boolean sellProduct(int soldCount);
}
