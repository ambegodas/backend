/**
 * @autor pathmasri
 * Nov 22, 2015 6:25:24 PM
 */
package com.ambegodas.backend.daoimpl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ambegodas.backend.dao.ProductDao;
import com.ambegodas.backend.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	public Product getProduct(String productCode) {
		// TODO Auto-generated method stub
		String queryStr = "select p from Product p WHERE p.code = :code";
		Query query = em.createQuery(queryStr);
		query.setParameter("code", productCode);	
		Product p = (Product)query.getSingleResult();	
		return p;
	}

	public Product updateProduct(Product product) {
		em.merge(product);
		return product;
	}

	public void deleteProduct(Product product) {
		em.remove(em.contains(product) ? product : em.merge(product));
		
	}

	public Product addProduct(Product product) {
		em.persist(product);
		return product;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.ProductDao#getProducts()
	 */
	public List<Product> getProducts() {
		String query = "select a from Product a";
		List<Product> products = em.createQuery(query,Product.class).getResultList();
		return products;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.ProductDao#sellProduct(int, long)
	 */
	public boolean sellProduct(int soldCount, long productId) {
		String queryString = "UPDATE Product p SET p.availableQty = p.availableQty- :soldCount, p.soldQty = p.soldQty + :soldCount "+
				" WHERE p.productId= :id";
		Query query = em.createQuery(queryString);

		query.setParameter("soldCount", soldCount);
		query.setParameter("id", productId);

		int updateCount = query.executeUpdate();

		if (updateCount > 0) {
			return true;
		}
		return false;
	}


	
}
