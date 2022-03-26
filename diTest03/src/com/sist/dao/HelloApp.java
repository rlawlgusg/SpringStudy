package com.sist.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sist/dao/beans.xml");
		MemberDAO m = (MemberDAO)context.getBean("dao");
		m.insert();
	}	

}
