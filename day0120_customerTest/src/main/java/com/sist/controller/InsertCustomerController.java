package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.customerDAO;
import com.sist.vo.customerVO;


@Controller
@RequestMapping(value="/insertCustomer.do")
public class InsertCustomerController {
	@Autowired
	private customerDAO dao;
	
	public void setDao(customerDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(customerVO c) { //Command Object
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(c);
		if(re == 1) {
			mav.setViewName("insertCustomerOK");
		}else {
			mav.addObject("msg", "고객 등록에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
}
