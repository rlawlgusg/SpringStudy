package com.example.test0315_jpa_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.test0315_jpa_book.service.BookService;
import com.example.test0315_jpa_book.service.CustomerService;
import com.example.test0315_jpa_book.service.OrdersService;
import com.example.test0315_jpa_book.service.View_ListOrdersService;
import com.example.test0315_jpa_book.service.View_ListOrdersService2;
import com.example.test0315_jpa_book.vo.Orders;

import lombok.Setter;

@Controller
@Setter
public class OrdersController {
	@Autowired
	private OrdersService os;
	@Autowired
	private BookService bs;
	@Autowired
	private CustomerService cs;
	@Autowired
	private View_ListOrdersService vls;
	@Autowired
	private View_ListOrdersService2 vls2;
	
	//@GetMapping("/listOrders")
	//public void list(Model model) {
	//	model.addAttribute("list", os.findAll());
	//}
	
	@GetMapping("/view_listOrders")
	public void list2(Model model) {
		model.addAttribute("list", vls.findAll());
	}
	@GetMapping("/view_listOrders2")
	public void list3(Model model) {
		model.addAttribute("list", vls2.findAll());
	}
	
	@GetMapping("/insertOrders")
	public void insert(Model model) {
		model.addAttribute("c_list",cs.findAll());
		model.addAttribute("b_list",bs.findAll());
		model.addAttribute("no",os.getNextNo());
	}
	
	@PostMapping("/insertOrders")
	public String insert(Orders o){
		os.insert(o);
		return "redirect:/listOrders";
	}
	
}