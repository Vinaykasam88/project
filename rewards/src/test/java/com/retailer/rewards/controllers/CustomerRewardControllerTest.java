package com.retailer.rewards.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.retailer.rewards.modals.Customer;
import com.retailer.rewards.modals.Transaction;
import com.retailer.rewards.services.CustomerRewardService;

@SpringBootTest
public class CustomerRewardControllerTest {

	@InjectMocks
	CustomerRewardController customerRewardController;

	@Mock
	CustomerRewardService customerRewardService;
	
	@Test
	public void testPositiveResponseCode() throws Exception {
		List<Transaction> txns = new ArrayList<>();
		Transaction txn1 = new Transaction();
		txn1.setId(1);
		txn1.setCustid(1);
		txn1.setPrice(120);
		txn1.setRewards(90);
		txn1.setTransactiondate(new Date());
		txns.add(txn1);
		ResponseEntity<?> entity = customerRewardController.getAllTransactions();
		when(customerRewardService.getAllTransactions()).thenReturn(txns);
		assertEquals(200, entity.getStatusCodeValue());
	}
	
	@Test
	public void testPositiveResponseCode1() throws Exception {
		List<Transaction> txns = new ArrayList<>();
		Transaction txn1 = new Transaction();
		txn1.setId(1);
		txn1.setCustid(1);
		txn1.setPrice(120);
		txn1.setRewards(90);
		txn1.setTransactiondate(new Date());
		txns.add(txn1);
		ResponseEntity<?> entity = customerRewardController.getReawrdsperThreeMonths();
		when(customerRewardService.getAllTransactions()).thenReturn(txns);
		assertEquals(200, entity.getStatusCodeValue());
	}
	
	@Test
	public void testPositiveResponseCode2() throws Exception {
		Customer cust = new Customer();
		cust.setCustId(1);
		cust.setPurchasedPrice(120);
		List<Transaction> txns = new ArrayList<>();
		Transaction txn1 = new Transaction();
		txn1.setId(1);
		txn1.setCustid(1);
		txn1.setPrice(120);
		txn1.setRewards(90);
		txn1.setTransactiondate(new Date());
		txns.add(txn1);
		ResponseEntity<?> entity = customerRewardController.addTransaction(cust);
		when(customerRewardService.addTransaction(cust)).thenReturn(txn1);
		assertEquals(200, entity.getStatusCodeValue());
	}
}
