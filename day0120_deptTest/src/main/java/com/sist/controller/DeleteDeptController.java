package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;

@Controller
public class DeleteDeptController {
	@Autowired
	private DeptDAO dao;
	
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/deleteDept.do")
	public ModelAndView delete(int dno) {
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");
		int re = dao.deleteDept(dno);
		if(re != 1) {
			mav.addObject("msg", "�μ������� �����Ͽ����ϴ�");
			mav.setViewName("error");
		}
		return mav;
	}
}
