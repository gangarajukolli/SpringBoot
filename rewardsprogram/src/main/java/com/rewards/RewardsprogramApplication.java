package com.rewards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RewardsprogramApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(RewardsprogramApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RewardsprogramApplication.class, args);
		LOGGER.info("Rewards program App initialized");
	}
	
}
