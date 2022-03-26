package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.CustomerVO;

@Repository
public class BookDAO {
	
	public List<BookVO> findAll(){
		return DBManager.findAll();
	}
	
	public List<String> listPublisher(){
		return DBManager.listPublisher();
	}
	
	public List<BookVO> bookByPublisher(String publisher){
		return DBManager.bookByPublisher(publisher);
	}
	
	
}
