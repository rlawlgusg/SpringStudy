package com.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@Controller
@RequestMapping(value="/insertDept.do")
public class InsertDeptController {
	@Autowired
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(DeptVO d) { //Command Object
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(d);
		if(re == 1) {
			mav.setViewName("insertDeptOK");
		}else {
			mav.addObject("msg", "�μ� ��Ͽ� �����Ͽ����ϴ�");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
}
