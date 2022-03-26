package com.sist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.EmpDao;
import com.sist.db.DBManager;
import com.sist.vo.EmpVO;

@Controller
public class EmpController {
	@Autowired
	private EmpDao dao;
	
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listEmp.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listEmp());
		return mav;
	}
}
