package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.customerDAO;

@Controller
public class DeleteCustomerController {
	@Autowired
	private customerDAO dao;
	
	
	public void setDao(customerDAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/deleteCustomer.do")
	public ModelAndView delete(int custid) {
		ModelAndView mav = new ModelAndView();
		int re = dao.deleteCustomer(custid);
		if(re == 1) {
			mav.setViewName("deleteCustomerOK");
		}else {
			mav.addObject("msg", "고객삭제에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}
