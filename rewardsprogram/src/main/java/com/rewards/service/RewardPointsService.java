/**
 * 
 */
package com.rewards.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rewards.RewardsprogramApplication;
import com.rewards.model.CustomerDetails;
import com.rewards.model.RewardPoints;
import com.rewards.model.RewardsResponse;
import com.rewards.model.Transaction;

import exception.BusinessException;

/**
 * @author gangaraju
 *
 */
@Service
public class RewardPointsService implements RewardsPointsServiceInterface {
	private static final Logger LOGGER=LoggerFactory.getLogger(RewardsprogramApplication.class);
	@Value("${validate.request.empty.error.code}")
	private String emptyRequestErrCd;

	@Value("${validate.request.empty.error.msg}")
	private String emptyRequestErrMsg;
	
	@Value("${validate.uknown.error.code}")
	private String unkonwnErrCd;

	@Value("${validate.uknown.error.empty.msg}")
	private String unkonwnErrMsg;

	/**
	 * Service to calculate the rewards points for the given customers
	 * @param customerDetaisList
	 * @return
	 */
	@Override
	public List<RewardsResponse> getRewards(List<CustomerDetails> customerDetaisList) {

		LOGGER.info("Reward service");
		List<RewardsResponse> response = new ArrayList<>();

		validateRequest(customerDetaisList);
		try {
			for (CustomerDetails customer : customerDetaisList) {
				RewardsResponse customerRewardResponse = new RewardsResponse();
				List<RewardPoints> rewardPointsList = new ArrayList<>();
				Map<String, Long> monthWiseRewards = calculateRewards(customer);
				customerRewardResponse.setCustomerId(customer.getCustomerId());
				customerRewardResponse.setCustomerName(customer.getCustomerName());
				monthWiseRewards.forEach((key, value) -> {
					RewardPoints rewardPoints = new RewardPoints();
					rewardPoints.setMonth(key);
					rewardPoints.setPonts(value);
					rewardPointsList.add(rewardPoints);
				});
				customerRewardResponse.setPoints(rewardPointsList);
				response.add(customerRewardResponse);
			}
		} catch (Exception e) {
			throw new BusinessException("500", "Something went wrong!" + e.getMessage());
		}
		return response;

	}
	
	/**
	 * To validate the request payload
	 * @param customerDetaisList
	 */
	private void validateRequest(List<CustomerDetails> customerDetaisList) {
		LOGGER.info("Validating the request");
		if (customerDetaisList == null || customerDetaisList.size() == 0) {
			throw new BusinessException(emptyRequestErrCd, emptyRequestErrMsg);
		}

	}

	/**
	 * To calculate the reward points earned for each customer per month and total.
	 * @param request
	 * @return
	 */
	private Map<String, Long> calculateRewards(CustomerDetails request) {
		LOGGER.info("Calculating the rewards for the customer: "+request.getCustomerName());
		Map<String, Long> transactionValueMap = new HashMap<>();
		Map<String, Long> rewardPointsMap = new HashMap<>();
		List<Transaction> ransList = request.getTransactions();
		try {
			for (Transaction transaction : ransList) {
				java.time.Month month = transaction.getTransactionDate().toInstant().atZone(ZoneId.systemDefault())
						.getMonth();

				if (transactionValueMap.containsKey(month.name())) {
					long existingTransactinValue = transactionValueMap.get(month.name());
					transactionValueMap.put(month.name(), existingTransactinValue + transaction.getTransactionVale());
				} else {
					transactionValueMap.put(month.name(), transaction.getTransactionVale());
				}
			}

			transactionValueMap.forEach((key, value) -> {
				long points;
				if (value <= 50) {
					rewardPointsMap.put(key, 0l);
				} else {
					long temp = value - 50;
					points = temp;
					value = value - 100;
					if (value >= 0) {
						points = points + value;
					}
					rewardPointsMap.put(key, points);
				}
			});
		} catch (Exception e) {
			throw new BusinessException(unkonwnErrCd, unkonwnErrMsg + e.getMessage());
		}

		return rewardPointsMap;
	}

}
