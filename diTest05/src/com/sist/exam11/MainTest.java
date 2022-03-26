package com.sist.exam11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.exam09.GoodsVO;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/sist/exam11/beans11.xml");
		OrderGoods orderGoods = (OrderGoods)context.getBean("orderGoods");
		orderGoods.order();
		
	}

}
