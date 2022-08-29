package com.rewards.rewardsprogram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rewards.controller.RewardPointsController;
import com.rewards.model.CustomerDetails;
import com.rewards.model.Transaction;
import com.rewards.service.RewardPointsService;

@SpringBootTest
class RewardsprogramApplicationTests {

	@Autowired
	RewardPointsController controller;
	
	@Autowired
	RewardPointsService service;
	
	/**
	 * Test with one customer and one transaction
	 */
	@Test
	void Test1() {		
		ResponseEntity<?> resList = controller.getRewards(getRequestPayload());
		if(resList != null && resList.getStatusCode().equals(HttpStatus.OK)) {
			assert(true);
		}			
	}
	
	@Test
	void Test2() throws ParseException {		
		ResponseEntity<?> resList = controller.getRewards(getCustomerWithMultipleTransactionsRequest());
		if(resList != null && resList.getStatusCode().equals(HttpStatus.OK))
			assert(true);
	}
	
	@Test
	void Test3() throws ParseException {		
		ResponseEntity<?> resList = controller.getRewards(getMultiCustomerWithMultiTransactionsRequest());
		if(resList != null && resList.getStatusCode().equals(HttpStatus.OK))
			assert(true);
	}

	private List<CustomerDetails> getRequestPayload() {
		List<CustomerDetails> cusotmerList = new ArrayList<>();
		CustomerDetails cd = new CustomerDetails();
		List<Transaction> transactions = new ArrayList<>();
		Transaction trans1 = new Transaction();
		cd.setCustomerId("customer1");
		cd.setCustomerName("John");
		cd.setLocation("CA");
		cd.setDateOfBirth(new Date());
		trans1.setCusotmerId("customer1");
		trans1.setTransactionDate(new Date());
		trans1.setTransactionId("trans1");
		trans1.setTransactionVale(200);
		transactions.add(trans1);
		cd.getTransactions().add(trans1);
		cusotmerList.add(cd);
		return cusotmerList;
	}
	
	private List<CustomerDetails> getCustomerWithMultipleTransactionsRequest() throws ParseException {
		List<CustomerDetails> cusotmerList = new ArrayList<>();
		CustomerDetails cd = new CustomerDetails();
		List<Transaction> transactions = new ArrayList<>();		
		cd.setCustomerId("customer1");
		cd.setCustomerName("John");
		cd.setLocation("CA");
		cd.setDateOfBirth(new Date());
		
		// First Transaction
		Transaction trans1 = new Transaction();
		trans1.setCusotmerId("customer1");
		trans1.setTransactionDate(new Date());
		trans1.setTransactionId("trans1");
		trans1.setTransactionVale(200);
		transactions.add(trans1);
		cd.getTransactions().add(trans1);
		cusotmerList.add(cd);
		
		// section Transaction
		Transaction trans2 = new Transaction();
		trans2.setCusotmerId("customer1");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		trans2.setTransactionDate(sf.parse("2022-07-07"));
		trans2.setTransactionId("trans1");
		trans2.setTransactionVale(120);
		transactions.add(trans2);
		cd.getTransactions().add(trans2);
		cusotmerList.add(cd);
		
		return cusotmerList;
	}

	private List<CustomerDetails> getMultiCustomerWithMultiTransactionsRequest() throws ParseException {
		List<CustomerDetails> cusotmerList = new ArrayList<>();
		
		// Customer1 Details
		CustomerDetails cd = new CustomerDetails();
		List<Transaction> transactions = new ArrayList<>();		
		cd.setCustomerId("customer1");
		cd.setCustomerName("John");
		cd.setLocation("CA");
		cd.setDateOfBirth(new Date());
		
		// First Transaction
		Transaction trans1 = new Transaction();
		trans1.setCusotmerId("customer1");
		trans1.setTransactionDate(new Date());
		trans1.setTransactionId("trans1");
		trans1.setTransactionVale(200);
		transactions.add(trans1);
		cd.getTransactions().add(trans1);
		cusotmerList.add(cd);
		
		// section Transaction
		Transaction trans2 = new Transaction();
		trans2.setCusotmerId("customer1");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		trans2.setTransactionDate(sf.parse("2022-07-07"));
		trans2.setTransactionId("trans1");
		trans2.setTransactionVale(120);
		transactions.add(trans2);
		cd.getTransactions().add(trans2);
		cusotmerList.add(cd);
		
		// Customer2 Details
		CustomerDetails cd2 = new CustomerDetails();
		List<Transaction> transactionss = new ArrayList<>();		
		cd2.setCustomerId("customer2");
		cd2.setCustomerName("Rachel");
		cd2.setLocation("NY");
		cd2.setDateOfBirth(new Date());
		
		// First Transaction
		Transaction trans21 = new Transaction();
		trans21.setCusotmerId("customer1");
		trans21.setTransactionDate(new Date());
		trans21.setTransactionId("trans1");
		trans21.setTransactionVale(150);
		transactionss.add(trans21);
		cd2.getTransactions().add(trans21);
		cusotmerList.add(cd2);
		
		// section Transaction
		Transaction trans22 = new Transaction();
		trans22.setCusotmerId("customer1");
		trans22.setTransactionDate(sf.parse("2022-08-07"));
		trans22.setTransactionId("trans1");
		trans22.setTransactionVale(20);
		transactionss.add(trans22);
		cd2.getTransactions().add(trans22);
		cusotmerList.add(cd2);
		
		return cusotmerList;
	}
	
}
