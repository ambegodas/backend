/**
 * @autor pathmasri
 * Nov 24, 2015 10:31:01 AM
 */
package com.ambegodas.backend.dao;

import java.util.List;

import com.ambegodas.backend.model.SalesOrder;

public interface SalesOrderDao {

    public SalesOrder getSalesOrder(long salesOrderId);
    public SalesOrder updateSalesOrder(SalesOrder salesOrder);
    public void deleteSalesOrder(SalesOrder salesOrder);
    public SalesOrder addSalesOrder(SalesOrder salesOrder);
    public List<SalesOrder> getSalesOrders();
	
}
