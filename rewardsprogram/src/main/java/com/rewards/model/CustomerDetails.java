/**
 * 
 */
package com.rewards.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gangaraju
 *
 */
public class CustomerDetails {

	private String customerId;
	private String customerName;
	private Date dateOfBirth;
	private String location;
	private List<Transaction> transactions;
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	//	/**
//	 * @return the dateOfBirth
//	 */
//	public String getDateOfBirth() {
//		return dateOfBirth;
//	}
//	/**
//	 * @param dateOfBirth the dateOfBirth to set
//	 */
//	public void setDateOfBirth(String dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		if(transactions == null) {
			transactions = new LinkedList<Transaction>();
		}
		return transactions;
	}
	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
