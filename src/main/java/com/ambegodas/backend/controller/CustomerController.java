/**
 * @autor pathmasri
 * Nov 22, 2015 10:50:16 PM
 */
package com.ambegodas.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambegodas.backend.model.Customer;
import com.ambegodas.backend.resource.CustomerResource;
import com.ambegodas.backend.resource.asm.CustomerResourceAsm;
import com.ambegodas.backend.service.CustomerService;

@Controller
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	public CustomerController(){
	}
	
	@RequestMapping(value="/customers/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<CustomerResource> getCustomer(@PathVariable long customerId){
	
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer != null){
			CustomerResource res = new CustomerResourceAsm().toResource(customer);
			return new ResponseEntity<CustomerResource>(res,HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerResource>(HttpStatus.NOT_FOUND);
		}				
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<CustomerResource> addCustomer(@RequestBody Customer customer){

		Customer newCustomer = customerService.addCustomer(customer);

		if(newCustomer != null){
			CustomerResource res = new CustomerResourceAsm().toResource(newCustomer);
			return new ResponseEntity<CustomerResource>(res,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<CustomerResource>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomers(){

		return	customerService.getCustomers().getCustomers();
	}

	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public ResponseEntity<CustomerResource> updateCustomer(@RequestBody Customer customer){

		Customer updatedCustomer = customerService.updateCustomer(customer);
		if(updatedCustomer != null){
			CustomerResource res = new CustomerResourceAsm().toResource(updatedCustomer);
			return new ResponseEntity<CustomerResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.DELETE)
	public ResponseEntity<CustomerResource> deleteCustomer(@RequestBody Customer customer){
		try{
			customerService.deleteCustomer(customer);
			return new ResponseEntity<CustomerResource>(HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<CustomerResource>(HttpStatus.EXPECTATION_FAILED);
		}
				
	}
	
	@RequestMapping(value="/customersByCode/{code}", method=RequestMethod.GET)
	public @ResponseBody Customer getCustomerByCode(@PathVariable String code){
		return customerService.getCustomerByCode(code);
				
	}
}
