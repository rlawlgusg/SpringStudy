package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDao dao;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void login_form() {
		
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login_submit(HttpSession session, String id, String pwd) {
		ModelAndView mav = new ModelAndView("loginOK");
		
		int re = dao.isMember(id, pwd);
		
		session.setAttribute("re", re);
		//re의 값이 1이면 로그인의 상태임
		
		if(re != 1) {
			mav.setViewName("redirect:/login");
		}else {
			session.setAttribute("role", dao.getRole(id));
			//로그인에 성공했다면 그 계정의 role을 세션에 상태유지함
			session.setAttribute("id", id);
		}
		return mav;
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/login");
		return mav;
	}
}
