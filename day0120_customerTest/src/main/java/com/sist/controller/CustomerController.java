package com.sist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.customerDAO;
import com.sist.vo.customerVO;


@Controller
public class CustomerController {
	
	@Autowired
	private customerDAO dao;
	
	
	public void setDao(customerDAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/listCustomer.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<customerVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("listCustomer");
		return mav;
	}
	
	
	@RequestMapping("/detailCustomer.do")
	public ModelAndView detail(int custid) {
		ModelAndView mav = new ModelAndView();	
		mav.addObject("c", dao.getCustomer(custid));	
		//요청한 서비스이름과 같은 view로 설정할때에는 
		//setViewName을 생략할 수 있습니다.
		return mav;
	}
	
}



