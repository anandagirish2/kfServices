package com.java.domain;

import java.math.BigDecimal;

public class Transaction {
	private int transactionId;
	private int customerId;
	private BigDecimal amount;
	private int monthValue;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getMonthValue() {
		return monthValue;
	}

	public void setMonthValue(int monthValue) {
		this.monthValue = monthValue;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", amount=" + amount
				+ ", monthValue=" + monthValue + "]";
	}
}
