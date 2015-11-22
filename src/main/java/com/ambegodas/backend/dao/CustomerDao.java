/**
 * @autor pathmasri
 * Nov 22, 2015 11:09:23 PM
 */
package com.ambegodas.backend.dao;

import java.util.List;

import com.ambegodas.backend.model.Customer;

public interface CustomerDao {

	 public Customer getCustomer(long  customerId);
	    public Customer updateCustomer(Customer customer);
	    public void deleteCustomer(Customer customer);
	    public Customer addCustomer(Customer customer);
	    public List<Customer> getCustomers();
	    public boolean sellCustomer(int soldCount,long customerId);
}
