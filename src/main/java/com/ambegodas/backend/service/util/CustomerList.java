/**
 * @autor pathmasri
 * Nov 22, 2015 11:03:05 PM
 */
package com.ambegodas.backend.service.util;

import java.util.ArrayList;
import java.util.List;

import com.ambegodas.backend.model.Customer;

public class CustomerList {

	 private List<Customer> customers = new ArrayList<Customer>();

	    public List<Customer> getCustomers() {
	        return customers;
	    }

	    public void setCustomers(List<Customer> customers) {
	        this.customers = customers;
	    }
}
