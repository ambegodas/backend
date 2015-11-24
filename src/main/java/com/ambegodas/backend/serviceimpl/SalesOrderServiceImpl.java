/**
 * @autor pathmasri
 * Nov 24, 2015 10:48:13 AM
 */
package com.ambegodas.backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ambegodas.backend.dao.CustomerDao;
import com.ambegodas.backend.dao.ProductDao;
import com.ambegodas.backend.dao.SalesOrderDao;
import com.ambegodas.backend.model.Customer;
import com.ambegodas.backend.model.OrderLine;
import com.ambegodas.backend.model.Product;
import com.ambegodas.backend.model.SalesOrder;
import com.ambegodas.backend.service.SalesOrderService;

@Repository
@Transactional
public class SalesOrderServiceImpl implements SalesOrderService {
	
	@Autowired
	private SalesOrderDao salesOrderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#getSalesOrder(java.lang.String)
	 */
	public SalesOrder getSalesOrder(String salesOrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#updateSalesOrder(com.ambegodas.backend.model.SalesOrder)
	 */
	public SalesOrder updateSalesOrder(SalesOrder salesOrder) {
		salesOrderDao.updateSalesOrder(salesOrder);
		return salesOrder;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#deleteSalesOrder(com.ambegodas.backend.model.SalesOrder)
	 */
	public void deleteSalesOrder(SalesOrder salesOrder) {
		salesOrderDao.deleteSalesOrder(salesOrder);
		
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#addSalesOrder(com.ambegodas.backend.model.SalesOrder)
	 */
	public SalesOrder addSalesOrder(SalesOrder salesOrder) {
		
		List<OrderLine> orderLines = salesOrder.getOrderLines();
		for(OrderLine order: orderLines){
			order.setSalesOrder(salesOrder);
		}		
		salesOrderDao.addSalesOrder(salesOrder);
		return salesOrder;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#getSalesOrders()
	 */
	public List<SalesOrder> getSalesOrders() {
		// TODO Auto-generated method stub
		return salesOrderDao.getSalesOrders();
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#validateInventory(com.ambegodas.backend.model.SalesOrder)
	 */
	public boolean validateInventory(SalesOrder salesOrder) {
		
		boolean available = true;
		
		List<OrderLine> orderLins = salesOrder.getOrderLines();		
		for(OrderLine order: orderLins){
			Product p = productDao.getProduct(order.getProductCode());
			if(p.getQuantity()<order.getQuantity()){
				return false;
			}
		}
		
		return available;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#validateCreditLimit(com.ambegodas.backend.model.SalesOrder)
	 */
	public boolean validateCreditLimit(SalesOrder salesOrder) {
		
		Customer customer = customerDao.getCustomer(salesOrder.getCustomerCode());
		double availableCredit = customer.getCreditLimit() - customer.getCurrentCredit();
		if(salesOrder.getPrice() > availableCredit){
			return false;
		} else {
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#updateInventory(com.ambegodas.backend.model.SalesOrder)
	 */
	public void updateInventory(SalesOrder salesOrder) {
		
		List<OrderLine> orderLins = salesOrder.getOrderLines();		
		for(OrderLine order: orderLins){
			Product p = productDao.getProduct(order.getProductCode());
            p.setQuantity(p.getQuantity()-order.getQuantity());
            productDao.updateProduct(p);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.service.SalesOrderService#updateCustomerCredit(com.ambegodas.backend.model.SalesOrder)
	 */
	public void updateCustomerCredit(SalesOrder salesOrder) {
		
		Customer customer = customerDao.getCustomer(salesOrder.getCustomerCode());
		customer.setCurrentCredit(customer.getCurrentCredit()+salesOrder.getPrice());
		customerDao.updateCustomer(customer);
	}
	
}
