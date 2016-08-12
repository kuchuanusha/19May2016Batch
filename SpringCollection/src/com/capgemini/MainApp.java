package com.capgemini;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Employee employee = context.getBean("employee",Employee.class);
		
		System.out.println(employee.getEmployeeNumber());
		
		System.out.println(employee.getName());
		
		
		
		int listLength=employee.getAddress().size();
		for(int i=0;i<listLength;i++){
		System.out.println(employee.getAddress().get(i).getCity());
		}
		
	
		
		Iterator iterator = employee.getAddressSet().iterator();
		while (iterator.hasNext()) {
		    System.out.println(iterator.next());
		}
		
		
		
		Iterator<Integer> keySetIterator = employee.getAddressMap().keySet().iterator();
		while(keySetIterator.hasNext()){
			Integer key = keySetIterator.next(); 
			System.out.println( " value: " + employee.getAddressMap().get(key).getCity());
			}

		
		
		System.out.println(employee.getAddressProperties());
		
	}

}
