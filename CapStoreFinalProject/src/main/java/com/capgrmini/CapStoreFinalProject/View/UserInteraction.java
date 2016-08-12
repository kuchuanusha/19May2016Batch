package com.capgrmini.CapStoreFinalProject.View;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class UserInteraction {


    
	IRefundService refundService;


	public UserInteraction()
	{
		refundService=new RefundServiceImpl();

}


private static Scanner sc=new Scanner(System.in);

public void refundMoney()
{
		
		
		
		System.out.println("enter orderId");
		int orderId=sc.nextInt();
		refundService.refundMoney(orderId);
		
		
		
}
}
