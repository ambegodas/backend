/**
 * @autor pathmasri
 * Nov 22, 2015 11:13:47 PM
 */
package com.ambegodas.backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambegodas.backend.dao.CustomerDao;
import com.ambegodas.backend.model.Customer;
import com.ambegodas.backend.service.CustomerService;
import com.ambegodas.backend.service.util.CustomerList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	

	public Customer getCustomer(long customerId) {
		return customerDao.getCustomer(customerId);
	}

	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);		
	}

	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.CustomerService#getCustomers()
	 */
	public CustomerList getCustomers() {
		List<Customer> accounts = customerDao.getCustomers();
		CustomerList customerList = new CustomerList();
		customerList.setCustomers(accounts);
		return customerList ;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.CustomerService#sellCustomer(int)
	 */
	public boolean sellCustomer(int soldCount) {
		// TODO Auto-generated method stub
		return false;
	}
}
