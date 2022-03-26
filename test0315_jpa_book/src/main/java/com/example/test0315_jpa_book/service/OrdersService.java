package com.example.test0315_jpa_book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test0315_jpa_book.dao.OrdersDAO;
import com.example.test0315_jpa_book.vo.Orders;

import lombok.Setter;

@Service
@Setter
public class OrdersService {
	@Autowired
	private OrdersDAO dao;
	
	public List<Orders> findAll(){
		return dao.findAll();
	}
	
	//JPA가 제공하는 save말고 우리가 만든 insert가 동작하도록 호출함
	public void insert(Orders o) {
		dao.insert(o);
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
}
