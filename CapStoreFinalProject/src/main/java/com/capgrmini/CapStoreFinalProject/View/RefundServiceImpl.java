package com.capgrmini.CapStoreFinalProject.View;

import com.capgrmini.CapStoreFinalProject.domain.BankDetails;
import com.capgrmini.CapStoreFinalProject.domain.Customer;
import com.capgrmini.CapStoreFinalProject.domain.Order;

public class RefundServiceImpl implements IRefundService {

	IRefundDao refundDao;


	public RefundServiceImpl()
	{
		refundDao=new RefundDaoImpl();
	}
	public String refundMoney(int orderId) {
		BankDetails bankdetails=new BankDetails();
		int customerId=refundDao.searchCustomerId(orderId);
		
		Customer customer=refundDao.searchCustomerBycustomerId(customerId);
		int BankAccountNumber=customer.getBankACcountNumber();

		Order order=refundDao.searchProductId(orderId);
	
		int cost=refundDao.searchPrice(order);
		
		int balance=refundDao.getBalance(BankAccountNumber);
				bankdetails.setBalance(balance+cost);
				
				return refundDao.refundMoney(bankdetails);

	}

}
