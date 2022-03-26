package com.example.demo.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;

@Controller
public class AdminController {
	
	@RequestMapping("/admin/menu1")
	public void menu1() {
	}
	@RequestMapping("/admin/menu2")
	public void menu2() {
	}
	@RequestMapping("/admin/menu3")
	public void menu3() {
	}
}
