/**
 * @autor pathmasri
 * Nov 22, 2015 10:57:08 PM
 */
package com.ambegodas.backend.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.ambegodas.backend.controller.CustomerController;
import com.ambegodas.backend.model.Customer;
import com.ambegodas.backend.resource.CustomerResource;

public class CustomerResourceAsm extends ResourceAssemblerSupport<Customer, CustomerResource>{

	public CustomerResourceAsm (){
		super(CustomerController.class,CustomerResource.class);
	}
	
	public CustomerResource toResource(Customer customer){
		
		CustomerResource customerResource = new CustomerResource();
		customerResource.setName(customer.getName());
		Link link = linkTo(methodOn(CustomerController.class).getCustomer(customer.getCustomerId())).withSelfRel(); customerResource.add(link);
		return customerResource;
	}
}
