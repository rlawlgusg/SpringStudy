package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import lombok.Setter;

@RestController //@Controller+@ResponseBody
@Setter
public class BookController {
	@Autowired
	private BookDAO dao;
	
	@RequestMapping("/listBook")
	public List<BookVO> list() {
		return dao.findAll();	
	}
	
	@RequestMapping("/listPublisher")
	public List<String> listPublisher() {
		return dao.listPublisher();	
	}
	
	@RequestMapping("/bookByPublisher")
	public List<BookVO> bookByPublisher(String publisher) {
		return dao.bookByPublisher(publisher);	
	}
}
