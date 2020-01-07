package com.java;

import com.java.domain.Customer;
import com.java.domain.CustomerSummaryDashboard;
import com.java.service.CustomerService;

public class Solution {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();

		Customer customer1 = customerService.createCustomer(new Customer(0));
		double startMonth1 = 5;
		double endMonth1 = startMonth1 + 3; // excluding the end month
		int daysInMonth1 = 31;
		CustomerSummaryDashboard dashboard1 = customerService.generateCustomerDashboardDetails(customer1, startMonth1, endMonth1, daysInMonth1);
		customerService.displayCustomerDashboardDetails(dashboard1, startMonth1, endMonth1);
		
		Customer customer2 = customerService.createCustomer(new Customer(1));
		double startMonth2 = 5;
		double endMonth2 = startMonth2 + 3; // excluding the end month
		int daysInMonth2 = 30;
		CustomerSummaryDashboard dashboard2 = customerService.generateCustomerDashboardDetails(customer2, startMonth2, endMonth2, daysInMonth2);
		customerService.displayCustomerDashboardDetails(dashboard2, startMonth2, endMonth2);
	}
}
