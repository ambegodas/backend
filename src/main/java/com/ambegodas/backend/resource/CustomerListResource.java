/**
 * @autor pathmasri
 * Nov 22, 2015 10:54:41 PM
 */
package com.ambegodas.backend.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.ambegodas.backend.model.Customer;

public class CustomerListResource extends ResourceSupport {
	 private List<Customer> customers = new ArrayList<Customer>();

	    public List<Customer> getCustomers() {
	        return customers;
	    }

	    public void setCustomers(List<Customer> customers) {
	        this.customers = customers;
	    }
}
