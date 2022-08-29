/**
 * 
 */
package com.rewards.model;

import java.util.Date;

/**
 * @author gangaraju
 *
 */
public class Transaction {

	private String cusotmerId;
	private String transactionId;
	private Date transactionDate;
	private long transactionVale;
	
	
	/**
	 * @return the cusotmerId
	 */
	public String getCusotmerId() {
		return cusotmerId;
	}
	/**
	 * @param cusotmerId the cusotmerId to set
	 */
	public void setCusotmerId(String cusotmerId) {
		this.cusotmerId = cusotmerId;
	}
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
//	/**
//	 * @return the transactionDate
//	 */
//	public String getTransactionDate() {
//		return transactionDate;
//	}
//	/**
//	 * @param transactionDate the transactionDate to set
//	 */
//	public void setTransactionDate(String transactionDate) {
//		this.transactionDate = transactionDate;
//	}
	/**
	 * @return the transactionVale
	 */
	public long getTransactionVale() {
		return transactionVale;
	}
	/**
	 * @param transactionVale the transactionVale to set
	 */
	public void setTransactionVale(long transactionVale) {
		this.transactionVale = transactionVale;
	}
	
}
