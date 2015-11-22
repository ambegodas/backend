/**
 * @autor pathmasri
 * Nov 22, 2015 6:59:03 PM
 */
package com.ambegodas.backend.resource;

import org.springframework.hateoas.ResourceSupport;

public class ProductResource extends ResourceSupport {

	private long productId;
	private String productName;
	
	
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
