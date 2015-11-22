/**
 * @autor pathmasri
 * Nov 22, 2015 10:53:41 PM
 */
package com.ambegodas.backend.resource;

import org.springframework.hateoas.ResourceSupport;

public class CustomerResource extends ResourceSupport {


	private long customerId;
	private String code;
	private String name;
	private String address;
	private String phone1;
	private String phone2;
	private double creditLimit;
	private double currentCredit;
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}
	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}
	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	/**
	 * @return the creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}
	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	/**
	 * @return the currentCredit
	 */
	public double getCurrentCredit() {
		return currentCredit;
	}
	/**
	 * @param currentCredit the currentCredit to set
	 */
	public void setCurrentCredit(double currentCredit) {
		this.currentCredit = currentCredit;
	}
	
}
