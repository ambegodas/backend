/**
 * @autor pathmasri
 * Nov 22, 2015 6:27:10 PM
 */
package com.ambegodas.backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambegodas.backend.dao.ProductDao;
import com.ambegodas.backend.model.Product;
import com.ambegodas.backend.service.ProductService;
import com.ambegodas.backend.service.util.ProductList;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	

	public Product getProduct(String productCode) {
		return productDao.getProduct(productCode);
	}

	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);		
	}

	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.ProductService#getProducts()
	 */
	public ProductList getProducts() {
		List<Product> accounts = productDao.getProducts();
		ProductList productList = new ProductList();
		productList.setProducts(accounts);
		return productList ;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.ProductService#sellProduct(int)
	 */
	public boolean sellProduct(int soldCount) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
