package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import lombok.Setter;


@Controller
@Setter
public class BookController {
	@Autowired
	private BookDAO dao;
	
	@RequestMapping("/listBook")
	public void listBook(Model model) {
		
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping("/DetailBook/{bookid}")
	public ModelAndView findByBookID(Model model, @PathVariable int bookid){
		ModelAndView mav = new ModelAndView();
		BookVO b = dao.findByBookID(bookid);
		model.addAttribute("b", b); 
		mav.setViewName("DetailBook.html");
		
		return mav;
	
	}
}
