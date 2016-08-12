package com.capgemini;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ApplicationContext context1 = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Employee employee = context.getBean("employee",Employee.class);
		
		Employee employee1= context1.getBean("employee",Employee.class);
	}

}
