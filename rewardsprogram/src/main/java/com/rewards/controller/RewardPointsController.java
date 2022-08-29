/**
 * 
 */
package com.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.model.CustomerDetails;
import com.rewards.model.RewardsResponse;
import com.rewards.service.RewardPointsService;

import exception.BusinessException;
import exception.ControllerException;

/**
 * @author gangaraju
 *
 */
@RestController
@RequestMapping("/api")
public class RewardPointsController {

	@Autowired
	RewardPointsService service;

	/**
	 * API to get reward points for the given customer transactions
	 * 
	 * @param customerDetais
	 * @return 
	 * @return
	 */
	@PostMapping(value = "/calculateRewards")
	public ResponseEntity<?> getRewards(@RequestBody List<CustomerDetails> customerDetais) {		
		
		try {
			List<RewardsResponse> resonse = service.getRewards(customerDetais);
			return new ResponseEntity<List<RewardsResponse>>(resonse, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrCode(),e.getErrMsg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("501","Something went wrong!");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
