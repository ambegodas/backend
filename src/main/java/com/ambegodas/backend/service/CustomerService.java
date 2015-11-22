/**
 * @autor pathmasri
 * Nov 22, 2015 11:12:42 PM
 */
package com.ambegodas.backend.service;

import com.ambegodas.backend.model.Customer;
import com.ambegodas.backend.service.util.CustomerList;

public interface CustomerService {


	public Customer getCustomer(long customerId);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer addCustomer(Customer customer);
	public CustomerList getCustomers();
	public boolean sellCustomer(int soldCount);
}
