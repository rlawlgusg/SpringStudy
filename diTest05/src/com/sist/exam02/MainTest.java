package com.sist.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/sist/exam02/beans02.xml");
		
		Dept dept = (Dept)context.getBean("dept");
		System.out.println(dept);
	
	}

}
