package com.java.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.java.domain.Customer;
import com.java.domain.CustomerSummaryDashboard;
import com.java.domain.OverallSummary;
import com.java.domain.Transaction;
import com.java.domain.TransactionSummary;

public class CustomerService {

	public Customer createCustomer(Customer customer) {
		if (customer != null) {
			customer.setNumberOfTransactions(ThreadLocalRandom.current().nextInt(1, 10));
			List<Transaction> transactions = new ArrayList<Transaction>();
			for (int i = 0; i < customer.getNumberOfTransactions(); i++) {
				Transaction transaction = new Transaction();
				transaction.setCustomerId(customer.getCustomerId());
				transaction.setMonthValue(ThreadLocalRandom.current().nextInt(0, 12));
				transaction.setAmount(new BigDecimal(ThreadLocalRandom.current().nextInt(0, 200)));
				transactions.add(transaction);
			}
			customer.setTransactions(transactions);
		}

		return customer;
	}

	public CustomerSummaryDashboard generateCustomerDashboardDetails(Customer customer, double monthStart,
			double monthEnd, int daysInMonth) {
		if (customer != null) {
			RewardService rewardService = new RewardService();
			Map<Integer, Transaction> monthTransactionMap = rewardService
					.getMonthTransactionsMap(customer.getTransactions());
			List<TransactionSummary> transactionSummaries = new ArrayList<TransactionSummary>();
			for (Integer monthValue : monthTransactionMap.keySet()) {
				TransactionSummary transactionSummary = rewardService.calculatePointsEarnedPerMonth(
						customer.getTransactions(), monthValue, customer.getCustomerId());
				transactionSummaries.add(transactionSummary);
			}

			OverallSummary overallSummary = rewardService.calculateTotalPointsEarned(transactionSummaries,
					customer.getCustomerId(), monthStart, monthEnd, daysInMonth);

			CustomerSummaryDashboard dashboard = new CustomerSummaryDashboard();
			dashboard.setOverallSummary(overallSummary);
			dashboard.setCustomerId(customer.getCustomerId());
			dashboard.setTransactionSummaries(transactionSummaries);

			return dashboard;

		}

		return null;
	}

	public void displayCustomerDashboardDetails(CustomerSummaryDashboard dashboard, double startMonth,
			double endMonth) {
		if (dashboard != null) {
			System.out.println("Customer ID: " + dashboard.getCustomerId());
			System.out.println("\n\t\t Transaction summaries:");
			System.out.println("\t\t ----------------------");
			for (TransactionSummary summary : dashboard.getTransactionSummaries()) {
				System.out.println("\tMonth: " + summary.getMonthValue());
				System.out.println("\tReward points: " + summary.getRewards());
				System.out.println();
			}

			System.out.println("\n\t\t\t\t Overall summary:");
			System.out.println("\t\t\t-------------------------------");
			OverallSummary summary = dashboard.getOverallSummary();
			System.out.println("\t\t\tStart month: " + startMonth);
			System.out.println("\t\t\tEnd months: " + endMonth);
			System.out.println("\t\t\tTotal reward points: " + summary.getTotalRewards());
			System.out.println("\t\t\t-------------------------------");
			System.out.println();
			System.out.println();
		}
	}
}
