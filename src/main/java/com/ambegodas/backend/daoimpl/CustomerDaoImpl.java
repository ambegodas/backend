/**
 * @autor pathmasri
 * Nov 22, 2015 11:10:14 PM
 */
package com.ambegodas.backend.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ambegodas.backend.dao.CustomerDao;
import com.ambegodas.backend.model.Customer;
import com.ambegodas.backend.model.Product;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@PersistenceContext
	private EntityManager em;

	public Customer getCustomer(long customerId) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, customerId);
	}

	public Customer updateCustomer(Customer customer) {
		em.merge(customer);
		return customer;
	}

	public void deleteCustomer(Customer customer) {
		em.remove(em.contains(customer) ? customer : em.merge(customer));
		
	}

	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.CustomerDao#getCustomers()
	 */
	public List<Customer> getCustomers() {
		String query = "select a from Customer a";
		List<Customer> customers = em.createQuery(query,Customer.class).getResultList();
		return customers;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.CustomerDao#getCustomer(java.lang.String)
	 */
	public Customer getCustomer(String customerCode) {
		String queryStr = "select c from Customer c WHERE c.code = :code";
		Query query = em.createQuery(queryStr);
		query.setParameter("code", customerCode);	
		Customer c = (Customer)query.getSingleResult();	
		return c;
	}

	

}
