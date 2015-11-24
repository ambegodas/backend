/**
 * @autor pathmasri
 * Nov 24, 2015 10:46:16 AM
 */
package com.ambegodas.backend.service;

import java.util.List;

import com.ambegodas.backend.model.SalesOrder;

public interface SalesOrderService {

	public SalesOrder getSalesOrder(String salesOrderId);
	public SalesOrder updateSalesOrder(SalesOrder salesOrder);
	public void deleteSalesOrder(SalesOrder salesOrder);
	public SalesOrder addSalesOrder(SalesOrder salesOrder);
	public List<SalesOrder> getSalesOrders();
	public boolean validateInventory(SalesOrder salesOrder);
	public boolean validateCreditLimit(SalesOrder salesOrder);
	public void updateInventory(SalesOrder salesOrder);
	public void updateCustomerCredit(SalesOrder salesOrder);
}
