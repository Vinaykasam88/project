package com.retailer.rewards.serviceimpls;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.rewards.modals.Customer;
import com.retailer.rewards.modals.Transaction;
import com.retailer.rewards.repos.CustomerRewardRepo;
import com.retailer.rewards.services.CustomerRewardService;

@Service
public class CustomerRewardServiceImpl implements CustomerRewardService {

	@Autowired
	CustomerRewardRepo customerRewardRepo;

	@Override
	public Transaction addTransaction(Customer customer) {
		Transaction transaction = new Transaction();
		transaction.setCustid(customer.getCustId());
		transaction.setPrice(customer.getPurchasedPrice());
		transaction.setRewards(calculateRewards(customer.getPurchasedPrice()));
		transaction.setTransactiondate(new Date());
		return customerRewardRepo.save(transaction);
	}

	public int calculateRewards(int price) {
		if (price >= 50 && price < 100) {
			return price - 50;
		} else if (price > 100) {
			return (2 * (price - 100) + 50);
		}
		return 0;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return customerRewardRepo.findAll();
	}

	@Override
	public List<Transaction> getReawrdsperThreeMonths() {
		List<Transaction> txns = customerRewardRepo.findAll();
		return txns.stream().filter(val -> convertToLocalDateViaSqlDate(val.getTransactiondate()))
				.collect(Collectors.toList());
	}

	public boolean convertToLocalDateViaSqlDate(Date dateToConvert) {
		LocalDate oldDate = new java.sql.Date(dateToConvert.getTime()).toLocalDate();
		String month = oldDate.getMonthValue() >= 9 ? "" + oldDate.getMonthValue() : "0" + oldDate.getMonthValue();

		LocalDate currentDate = LocalDate.now();
		LocalDate currentDateMinus3Months = currentDate.minusMonths(3);

		String currentMonth = currentDateMinus3Months.getMonthValue() >= 9
				? "" + currentDateMinus3Months.getMonthValue()
				: "0" + currentDateMinus3Months.getMonthValue();

		return !(LocalDate.parse((oldDate.getYear() - 1) + "-" + month + "-" + oldDate.getDayOfMonth())
				.isBefore(LocalDate.parse(currentDateMinus3Months.getYear() + "-" + currentMonth + "-"
						+ currentDateMinus3Months.getDayOfMonth())));
	}
}
