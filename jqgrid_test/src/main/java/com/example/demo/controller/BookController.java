package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import lombok.Setter;


@Controller
@Setter
public class BookController {
	@Autowired
	private BookDAO dao;
	
	
	@RequestMapping(value = "/listBook", produces = "application/xml")
	@ResponseBody
	public String listBook(int page, int rows, String sidx, String sord) {
		System.out.println("page:"+page);
		System.out.println("rows:"+rows);
		
		if(sidx == null) {
			System.out.println("null입니다");
		}
		
		if(sidx.equals("")) {
			System.out.println("''입니다.");
		}
		System.out.println("sidx:"+sidx);
		System.out.println("sord:"+sord);
		
		int records = dao.getTotalCount();
		int total = (int)Math.ceil(records/(double)rows);
		System.out.println("전체레코드수 : "+records);
		System.out.println("전체페이지수 : "+total);
		
		String r = "";
		r += "<rows>";	//매개변수로 전달받은 페이지를 설정
		r += "<page>"+page+"</page>";	//전체레코드수에 따른 페이지수를 설정
		r += "<total>"+total+"</total>"; //진짜로 db연동하여 전체레코드 수 설정
		r += "<record>"+records+"</record>";
		
		//만약 한화면에 10개씩 보여주고
		//현재페이지가 1페이지라면 보여줘야 할 시작레코드는 1,마지막 레코드는 10
		//현재페이지가 2페이지라면 보여줘야 할 시작레코드는 11,마지막 레코드는 20
		
		int start = (page-1)*rows+1;
		int end = start+rows-1;
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("sidx", sidx);
		map.put("sord", sord);
		
		List<BookVO> list = dao.findAll(map);
		
		for(BookVO b: list) {
			r += "<row>";
			r += "<cell>"+b.getBookid()+"</cell>";
			r += "<cell>"+b.getBookname()+"</cell>";
			r += "<cell>"+b.getPublisher()+"</cell>";
			r += "<cell>"+b.getPrice()+"</cell>";
			r += "</row>";
		}
		
		r += "</rows>";
		return r;
	}
	@RequestMapping("/editBook")
	@ResponseBody
	public String editBook(String oper, BookVO b,int bookid){
		System.out.println(oper);
		
		if(oper.equals("add")) {
			dao.insert(b);
		}else if(oper.equals("edit")) {
			dao.update(b);
		}else {
			dao.delete(b.getBookid());
		}
		
		return "OK";
	}

}
