package com.sist.exam13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.exam13.SystemMonitor;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/sist/exam13/beans13.xml");
		SystemMonitor systemMonitor = (SystemMonitor)context.getBean("systemMonitor");
		systemMonitor.monitor();
	}

}
