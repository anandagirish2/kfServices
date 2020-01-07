package com.java.domain;

import java.util.List;

public class Customer {
	private int customerId;
	private int numberOfTransactions;
	private List<Transaction> transactions;

	public Customer(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", numberOfTransactions=" + numberOfTransactions
				+ ", transactions=" + transactions + "]";
	}

}
