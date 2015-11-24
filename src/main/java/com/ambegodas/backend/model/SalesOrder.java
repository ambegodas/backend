/**
 * @autor pathmasri
 * Nov 22, 2015 11:46:46 PM
 */
package com.ambegodas.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SalesOrder {
	
	@Id @GeneratedValue
	private long salesOrderId;
	
	private double price;
	
	private String customerCode;
	
	private String salesOrderCode;
	
	private boolean isValid;
	
	/**
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@OneToMany(mappedBy="salesOrder",cascade = CascadeType.PERSIST, fetch= FetchType.LAZY)
	private List<OrderLine> orderLines;

	/**
	 * @return the orderLines
	 */
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param orderLines the orderLines to set
	 */
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	/**
	 * @return the salesOrderId
	 */
	public long getSalesOrderId() {
		return salesOrderId;
	}

	/**
	 * @param salesOrderId the salesOrderId to set
	 */
	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return the salesOrderCode
	 */
	public String getSalesOrderCode() {
		return salesOrderCode;
	}

	/**
	 * @param salesOrderCode the salesOrderCode to set
	 */
	public void setSalesOrderCode(String salesOrderCode) {
		this.salesOrderCode = salesOrderCode;
	}
	
	
}
