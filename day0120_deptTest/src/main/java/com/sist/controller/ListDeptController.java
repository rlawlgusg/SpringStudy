package com.sist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@Controller
public class ListDeptController {
	@Autowired
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listDept.do")
	public ModelAndView hello() {
		System.out.println("컨트롤러 동작함");
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("list", dao.listAll());
		mav.setViewName("listDept");
		return mav;
	}
	
	@RequestMapping("/detailDept.do")
	public ModelAndView detail(int dno) {
		ModelAndView mav = new ModelAndView();	
		mav.addObject("d", dao.getDept(dno));	
		//요청한 서비스이름과 같은 view로 설정할때에는 
		//setViewName을 생략할 수 있습니다.
		return mav;
	}
}
