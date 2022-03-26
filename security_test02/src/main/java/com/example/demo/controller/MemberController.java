package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join_form() {
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public void join_submit(MemberVO m ) {
		m.setPwd(passwordEncoder.encode(m.getPwd()));
		int re = dao.insert(m);
		if(re == 1) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping("/loginOK") //시큐리티 환경설정파일에서 로그인을 성공하면 여기로 오도록 설정
	public void loginOK(HttpSession session) {
		//로그인한 회원의 정보를 브라우저를 닫기 전까지(로그아웃 하기 전까지)유지하기 위하여 session을 매개변수로 설정 
		//스프링시큐리티에서는 우리가 로그인폼만 만들었고 로그인 처리는 시큐리티가 해 주었음
		//로그인한 회원의 정보를 파악하기 위해서는 다음과 같이 시큐리티에 요청함
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal(); //시큐리티가 인증한(로그인한) 사용자의 정보를 읽어옴
		//인증된 User객체의 id를 뽑아옴
		String id = user.getUsername();
		//인증된 User를 통해서는 아이디만 알아올 수 있음
		//만약 로그인한 회원의 다른 정보도 필요하다면 db를 통해서 뽑아옴 
		MemberVO m = dao.findById(id);
		//db로 부터 읽어온 회원객체를 세션에 상태유지함
		//세션에 상태유지를 하면 브라우저를 닫기 전까지(로그아웃 하기 전까지) 상태유지 할 수 있음
		session.setAttribute("m", m);
	}
	
	@RequestMapping("/list")
	public void list() {
	}
	
}
