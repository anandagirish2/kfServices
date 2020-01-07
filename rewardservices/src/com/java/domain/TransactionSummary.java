package com.java.domain;

import java.util.ArrayList;
import java.util.List;

public class TransactionSummary {
	private int customerId;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private int monthValue;
	private int rewards;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getMonthValue() {
		return monthValue;
	}

	public void setMonthValue(int monthValue) {
		this.monthValue = monthValue;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}

	@Override
	public String toString() {
		return "TransactionSummary [customerId=" + customerId + ", transactions=" + transactions + ", monthValue="
				+ monthValue + ", rewards=" + rewards + "]";
	}

}
