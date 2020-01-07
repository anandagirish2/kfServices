package com.java.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerSummaryDashboard {
	private int customerId;
	private List<TransactionSummary> transactionSummaries = new ArrayList<TransactionSummary>();
	private OverallSummary overallSummary;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<TransactionSummary> getTransactionSummaries() {
		return transactionSummaries;
	}

	public void setTransactionSummaries(List<TransactionSummary> transactionSummaries) {
		this.transactionSummaries = transactionSummaries;
	}

	public OverallSummary getOverallSummary() {
		return overallSummary;
	}

	public void setOverallSummary(OverallSummary overallSummary) {
		this.overallSummary = overallSummary;
	}

	@Override
	public String toString() {
		return "CustomerSummaryDashboard [customerId=" + customerId + ", transactionSummaries=" + transactionSummaries
				+ ", overallSummary=" + overallSummary + "]";
	}

}
