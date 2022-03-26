package com.example.test0315_jpa_book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test0315_jpa_book.dao.CustomerDAO;
import com.example.test0315_jpa_book.vo.Customer;

import lombok.Setter;

@Service
@Setter
public class CustomerService {
	@Autowired
	private CustomerDAO dao;
	
	public List<Customer> findAll(){
		return dao.findAll();
	}
}
