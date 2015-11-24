/**
 * @autor pathmasri
 * Nov 24, 2015 10:37:51 AM
 */
package com.ambegodas.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ambegodas.backend.dao.SalesOrderDao;
import com.ambegodas.backend.model.SalesOrder;
import com.ambegodas.backend.service.util.SalesOrderTo;

@Repository
public class SalesOrderDaoimpl implements SalesOrderDao {

	
	@PersistenceContext
	private EntityManager em;

	public SalesOrder getSalesOrder(long salesOrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.SalesOrderDao#updateSalesOrder(com.ambegodas.backend.model.SalesOrder)
	 */
	public SalesOrder updateSalesOrder(SalesOrder salesOrder) {
		em.merge(salesOrder);
		return salesOrder;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.SalesOrderDao#deleteSalesOrder(com.ambegodas.backend.model.SalesOrder)
	 */
	public void deleteSalesOrder(SalesOrder salesOrder) {
		em.remove(em.contains(salesOrder) ? salesOrder : em.merge(salesOrder));		
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.SalesOrderDao#addSalesOrder(com.ambegodas.backend.model.SalesOrder)
	 */
	public SalesOrder addSalesOrder(SalesOrder salesOrder) {
		em.persist(salesOrder);
		return salesOrder;
	}

	/* (non-Javadoc)
	 * @see com.ambegodas.backend.dao.SalesOrderDao#getSalesOrders()
	 */
	public List<SalesOrder> getSalesOrders() {
		String query = "select a from SalesOrder a";
		List<SalesOrder> salesOrders = em.createQuery(query,SalesOrder.class).getResultList();
        return salesOrders;
	}
	
	

}
