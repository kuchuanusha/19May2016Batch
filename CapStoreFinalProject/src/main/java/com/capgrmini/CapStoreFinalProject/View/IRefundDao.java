package com.capgrmini.CapStoreFinalProject.View;

import com.capgrmini.CapStoreFinalProject.domain.BankDetails;
import com.capgrmini.CapStoreFinalProject.domain.Customer;
import com.capgrmini.CapStoreFinalProject.domain.Order;

public interface IRefundDao {

	int searchCustomerId(int orderId);

	Order searchProductId(int orderId);

	Customer searchCustomerBycustomerId(int customerId);

	int searchPrice(Order order);

	int getBalance(int bankAccountNumber);

	String refundMoney(BankDetails bankdetails);
	
	

}
