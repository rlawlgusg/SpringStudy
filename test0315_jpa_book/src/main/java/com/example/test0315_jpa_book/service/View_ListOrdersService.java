package com.example.test0315_jpa_book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.test0315_jpa_book.dao.View_listOrdersDAO;
import com.example.test0315_jpa_book.vo.View_ListOrders;

import lombok.Setter;

@Service
@Setter
public class View_ListOrdersService {
	@Autowired
	private View_listOrdersDAO dao;
	
	public List<View_ListOrders> findAll(){
		return dao.findAll();
	}
}
