package com.retailer.rewards.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailer.rewards.modals.Transaction;

@Repository
public interface CustomerRewardRepo extends JpaRepository<Transaction, Long> {

}
