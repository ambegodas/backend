/**
 * @autor pathmasri
 * Nov 24, 2015 10:29:28 AM
 */
package com.ambegodas.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ambegodas.backend.model.Product;
import com.ambegodas.backend.model.SalesOrder;
import com.ambegodas.backend.service.SalesOrderService;
import com.ambegodas.backend.service.util.SalesOrderTo;

@Controller
public class SalesController {
	
	private SalesOrderService salesOrderService;
	
	
	@Autowired
	public SalesController(SalesOrderService salesOrderService){
		this.salesOrderService = salesOrderService;
	}
	
	public SalesController(){
	}

	@RequestMapping(value = "/salesOrder", method = RequestMethod.POST)
	public @ResponseBody SalesOrder addSalesOrder(@RequestBody SalesOrder salesOrder){

		if(salesOrderService.validateCreditLimit(salesOrder) && salesOrderService.validateInventory(salesOrder)){
			salesOrderService.updateCustomerCredit(salesOrder);
			salesOrderService.updateInventory(salesOrder);
			salesOrder.setValid(true);
		    salesOrder = salesOrderService.addSalesOrder(salesOrder);
		} else {
			salesOrder.setValid(false);
		}		
        return salesOrder;
	}
	
	@RequestMapping(value = "/salesOrder", method = RequestMethod.PUT)
	public @ResponseBody SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder){

		SalesOrder newSalesOrder = salesOrderService.updateSalesOrder(salesOrder);
        return newSalesOrder;
	}
	
	@RequestMapping(value = "/salesOrder", method = RequestMethod.DELETE)
	public void deleteSalesOrder(@RequestBody SalesOrder salesOrder){

	  salesOrderService.deleteSalesOrder(salesOrder);
	}
	
	@RequestMapping(value = "/salesOrders", method = RequestMethod.GET)
	public @ResponseBody List<SalesOrderTo> getProducts(){
		
        List<SalesOrderTo> sales = new ArrayList<SalesOrderTo>();
		
		for(SalesOrder s: salesOrderService.getSalesOrders()){
			SalesOrderTo st = new SalesOrderTo();
			st.setSalesOrderCode(s.getSalesOrderCode());
			st.setPrice(s.getPrice());
			st.setCustomerCode(s.getCustomerCode());
			sales.add(st);
		}
		
		return	sales;
	}
	
}
