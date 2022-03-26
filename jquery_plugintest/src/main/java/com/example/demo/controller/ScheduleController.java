package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ScheduleDAO;
import com.example.demo.vo.ScheduleVO;

import lombok.Setter;

@RestController
@Setter
public class ScheduleController {
	@Autowired
	private ScheduleDAO dao;
	
	@RequestMapping("/insertSchedule")
	public String insert(ScheduleVO s) {
		int re = dao.insert(s);
		return re+"";
	}
	@RequestMapping("/listSchedule")
	public List<ScheduleVO> findAll() {
		List<ScheduleVO> list = dao.findAll();
		return list;
	}
}
