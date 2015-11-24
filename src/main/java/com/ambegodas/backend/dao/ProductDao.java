/**
 * @autor pathmasri
 * Nov 22, 2015 6:21:41 PM
 */
package com.ambegodas.backend.dao;

import java.util.List;

import com.ambegodas.backend.model.Product;

public interface ProductDao {

    public Product getProduct(String  productCode);
    public Product updateProduct(Product product);
    public void deleteProduct(Product product);
    public Product addProduct(Product product);
    public List<Product> getProducts();
    public boolean sellProduct(int soldCount,long productId);
}
