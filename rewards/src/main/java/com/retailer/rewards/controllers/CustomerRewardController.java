package com.retailer.rewards.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.rewards.modals.Customer;
import com.retailer.rewards.modals.Transaction;
import com.retailer.rewards.services.CustomerRewardService;

@RestController
public class CustomerRewardController {

	private static final Logger LOG = LogManager.getLogger(CustomerRewardController.class.getName());

	@Autowired
	CustomerRewardService customerRewardService;

	@PostMapping(path = "/addTransaction")
	public ResponseEntity<?> addTransaction(@RequestBody Customer customer) {
		try {
			LOG.info("[ addTransaction method {} ]");
			return new ResponseEntity<Transaction>(customerRewardService.addTransaction(customer), HttpStatus.OK);
		} catch (Exception e) {
			LOG.debug("[ addTransaction Exception {} ]", e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "/getAllTransactions")
	public ResponseEntity<?> getAllTransactions() {
		try {
			LOG.info("[ getAllTransactions method {} ]");
			return new ResponseEntity<List<Transaction>>(customerRewardService.getAllTransactions(), HttpStatus.OK);
		} catch (Exception e) {
			LOG.debug("[ getAllTransactions Exception {} ]", e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/getReawrdsper3Months")
	public ResponseEntity<?> getReawrdsperThreeMonths() {
		try {
			LOG.info("[ getReawrdsper3Months method {} ]");
			return new ResponseEntity<List<Transaction>>(customerRewardService.getReawrdsperThreeMonths(), HttpStatus.OK);
		} catch (Exception e) {
			LOG.debug("[ getReawrdsper3Months Exception {} ]", e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	


}
