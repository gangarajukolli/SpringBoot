/**
 * 
 */
package com.rewards.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author gangaraju
 *
 */
public class RewardsResponse {

	private String customerId;
	private String customerName;
	private List<RewardPoints> points;
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
	 * @return the points
	 */
	public List<RewardPoints> getPoints() {
		if(points == null) {
			points = new LinkedList<RewardPoints>();
		}
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(List<RewardPoints> points) {
		this.points = points;
	}	
}
