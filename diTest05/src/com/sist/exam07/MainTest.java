package com.sist.exam07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/sist/exam07/beans07.xml");
		WriteArticleServicelmpl ws = (WriteArticleServicelmpl)context.getBean("ws");
		ws.insert();
	}

}
