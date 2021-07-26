package com.retailer.rewards.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retailer.rewards.modals.Customer;
import com.retailer.rewards.modals.Transaction;

@Service
public interface CustomerRewardService {

	public Transaction addTransaction(Customer customer);

	public List<Transaction> getAllTransactions();

	public List<Transaction> getReawrdsperThreeMonths();

}
