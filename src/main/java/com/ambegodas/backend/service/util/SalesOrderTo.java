/**
 * @autor pathmasri
 * Nov 24, 2015 2:10:16 PM
 */
package com.ambegodas.backend.service.util;

public class SalesOrderTo {
	
	private double price;
	
	private String customerCode;
	
	private String salesOrderCode;

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
