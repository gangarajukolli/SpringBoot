/**
 * 
 */
package com.rewards.service;

import java.util.List;

import com.rewards.model.CustomerDetails;
import com.rewards.model.RewardsResponse;

/**
 * @author gangaraju
 *
 */
public interface RewardsPointsServiceInterface {

	public List<RewardsResponse> getRewards(List<CustomerDetails> customerDetaisList);
	
}