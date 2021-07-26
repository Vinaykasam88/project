package com.retailer.rewards.modals;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue
	private int id;

	private int price;
	private int custid;
	private int rewards;

	@Temporal(TemporalType.DATE)
	private Date transactiondate;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	
	

}
