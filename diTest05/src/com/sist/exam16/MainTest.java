package com.sist.exam16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/sist/exam16/beans16.xml");
		WriteArticleServicelmpl ws = (WriteArticleServicelmpl)context.getBean("ws");
		ws.insert();
	}

}
