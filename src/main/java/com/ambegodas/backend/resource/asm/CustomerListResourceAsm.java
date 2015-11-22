/**
 * @autor pathmasri
 * Nov 22, 2015 11:01:32 PM
 */
package com.ambegodas.backend.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import com.ambegodas.backend.controller.CustomerController;
import com.ambegodas.backend.resource.CustomerListResource;
import com.ambegodas.backend.service.util.CustomerList;


public class CustomerListResourceAsm extends ResourceAssemblerSupport<CustomerList,CustomerListResource>  {

	public CustomerListResourceAsm() {
        super(CustomerController.class, CustomerListResource.class);
    }

	/* (non-Javadoc)
	 * @see org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object)
	 */
	public CustomerListResource toResource(CustomerList customerList) {
		CustomerListResource customerListResource = new CustomerListResource();
        customerListResource.setCustomers(customerList.getCustomers());

        Link link = linkTo(methodOn(CustomerController.class).getCustomers()).withSelfRel();
        customerListResource.add(link);
        return customerListResource;
	}

}
