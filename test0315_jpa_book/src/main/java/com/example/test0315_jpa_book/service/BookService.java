package com.example.test0315_jpa_book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test0315_jpa_book.dao.BookDAO;
import com.example.test0315_jpa_book.vo.Book;

import lombok.Setter;

@Service
@Setter
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public List<Book> findAll(){
		return dao.findAll();
	}

}
