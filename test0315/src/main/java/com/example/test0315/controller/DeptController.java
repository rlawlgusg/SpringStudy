package com.example.test0315.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test0315.service.DeptService;
import com.example.test0315.vo.DeptVO;

import lombok.Setter;

@Controller
@Setter
public class DeptController {
	
	@Autowired
	private DeptService ds;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",ds.findAll());
	}
	
	//등록할때, 수정할때 사용함
	//만약에 부서번호가 테이블에 이미 존재한다면 수정하고 없으면 등록함
	@PostMapping("/save")
	public String save(DeptVO d) {
		ds.save(d);
		return "redirect:/list";
	}
	
	@GetMapping("/update")
	public void update(int dno,Model model) {
		model.addAttribute("d", ds.getDept(dno));
	}
	
	@GetMapping("/delete")
	public String delete(int dno) {
		ds.delete(dno);
		return "redirect:/list";
	}
	
	
}
