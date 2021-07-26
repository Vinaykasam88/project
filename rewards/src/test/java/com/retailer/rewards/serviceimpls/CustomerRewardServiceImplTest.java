package com.retailer.rewards.serviceimpls;

import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.retailer.rewards.modals.Customer;
import com.retailer.rewards.modals.Transaction;

@SpringBootTest
public class CustomerRewardServiceImplTest  {
	@Autowired
	private CustomerRewardServiceImpl customerRewardService;

	@Test
	public void testResponse() throws Exception {
		List<Transaction> txns = new ArrayList<>();
		Transaction txn1 = new Transaction();
		txn1.setId(1);
		txn1.setCustid(1);
		txn1.setPrice(120);
		txn1.setRewards(90);
		txn1.setTransactiondate(new Date());
		txns.add(txn1);
		List<Transaction>  entity = customerRewardService.getAllTransactions();
		List<Transaction>  response = new ArrayList<>();
		response.add(txn1);
		Assertions.assertEquals(response.get(0).getId(), entity.get(0).getId());
	}
	
	@Test
	public void testResponse2() throws Exception {
		List<Transaction> txns = new ArrayList<>();
		Transaction txn1 = new Transaction();
		txn1.setId(13);
		txn1.setCustid(1);
		txn1.setPrice(120);
		txn1.setRewards(90);
		txn1.setTransactiondate(new Date());
		txns.add(txn1);
		List<Transaction>  entity = customerRewardService.getReawrdsperThreeMonths();
		List<Transaction>  response = new ArrayList<>();
		response.add(txn1);
		Assertions.assertEquals(response.get(0).getId(), entity.get(1).getId());
	}
	@Test
	public void testResponse3() throws Exception {
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
		Transaction  entity = customerRewardService.addTransaction(cust);
		
		Assertions.assertEquals(txn1.getId(), entity.getId());
	}
}
