package com.capgrmini.CapStoreFinalProject.View;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgrmini.CapStoreFinalProject.domain.BankDetails;
import com.capgrmini.CapStoreFinalProject.domain.Customer;
import com.capgrmini.CapStoreFinalProject.domain.Order;


public class RefundDaoImpl implements IRefundDao {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public RefundDaoImpl() {
		this.emf = Persistence.createEntityManagerFactory("hello");
		this.em = emf.createEntityManager();
	}

	public int searchCustomerId(int orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Order searchProductId(int orderId) {
		TypedQuery<Order> query = em.createQuery("Select o from Order o",Order.class);
		
		for(Order o:query.getResultList())
		{
			if(o.getOrderId()==orderId )
			{
				return o;
			}
		}
		
		
			return null;
	}

	public Customer searchCustomerBycustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int searchPrice(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getBalance(int bankAccountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String refundMoney(BankDetails bankdetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public int searchPrice(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

}
