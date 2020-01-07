package com.java.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.domain.OverallSummary;
import com.java.domain.Transaction;
import com.java.domain.TransactionSummary;

public class RewardService {

	public TransactionSummary calculatePointsEarnedPerMonth(List<Transaction> transactions, int monthValue,
			int customerId) {
		int rewards = 0;

		TransactionSummary summary = new TransactionSummary();
		summary.setMonthValue(monthValue);
		summary.setCustomerId(customerId);

		if (!transactions.isEmpty()) {
			for (Transaction transaction : transactions) {
				if (transaction.getMonthValue() == monthValue && transaction.getCustomerId() == customerId) {
					summary.getTransactions().add(transaction);

					BigDecimal amount = transaction.getAmount();

					BigDecimal dollarAmountOverHundred = BigDecimal.ZERO;
					BigDecimal dollarAmountOverFifty = BigDecimal.ZERO;
					BigDecimal differenceOverHundred = amount.subtract(new BigDecimal(100));

					if (differenceOverHundred.compareTo(BigDecimal.ZERO) == 1) {
						dollarAmountOverHundred = differenceOverHundred.multiply(new BigDecimal(2));
						dollarAmountOverFifty = new BigDecimal(50);
					}

					BigDecimal differenceOverFifty = amount.subtract(new BigDecimal(50));
					if (differenceOverFifty.compareTo(BigDecimal.ZERO) == 1
							&& differenceOverHundred.compareTo(BigDecimal.ZERO) < 1) {
						dollarAmountOverFifty = differenceOverFifty;
					}

					rewards += dollarAmountOverHundred.add(dollarAmountOverFifty).intValue();
				}
			}
		}

		summary.setRewards(rewards);
		return summary;
	}

	public OverallSummary calculateTotalPointsEarned(Collection<TransactionSummary> collection, int customerId,
			double startMonth, double endMonth, int daysInMonth) {
		if (!collection.isEmpty()) {
			int totalRewards = 0;
			OverallSummary overallSummary = new OverallSummary();
			overallSummary.setCustomerId(customerId);

			for (TransactionSummary transactionSummary : collection) {
				if (transactionSummary.getCustomerId() == customerId && startMonth <= transactionSummary.getMonthValue()
						&& transactionSummary.getMonthValue() < endMonth) {
					overallSummary.getTransactionSummaries().add(transactionSummary);

					totalRewards += transactionSummary.getRewards();
				}
			}

			overallSummary.setTotalRewards(totalRewards);
			return overallSummary;
		}

		return null;

	}

	public Map<Integer, Transaction> getMonthTransactionsMap(List<Transaction> transactions) {
		Map<Integer, Transaction> map = new HashMap<Integer, Transaction>();
		if (!transactions.isEmpty()) {
			for (Transaction transaction : transactions) {
				map.put(transaction.getMonthValue(), transaction);
			}
		}
		return map;
	}
}
