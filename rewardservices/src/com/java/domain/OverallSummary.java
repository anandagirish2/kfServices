package com.java.domain;

import java.util.ArrayList;
import java.util.List;

public class OverallSummary {
	private List<TransactionSummary> transactionSummaries = new ArrayList<TransactionSummary>();
	private int customerId;
	private int totalRewards;

	public List<TransactionSummary> getTransactionSummaries() {
		return transactionSummaries;
	}

	public void setTransactionSummaries(List<TransactionSummary> transactionSummaries) {
		this.transactionSummaries = transactionSummaries;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}

	@Override
	public String toString() {
		return "OverallSummary [transactionSummaries=" + transactionSummaries + ", customerId=" + customerId
				+ ", totalRewards=" + totalRewards + "]";
	}

}
