package com.example.test0315_jpa_book.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	//Book테이블과 Orders테이블은 bookid로 관계에 있음
	//하나의 도서에 대하여 여러 주문이 있을 수 있음
	//1:n의 관계
	@OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
	private List<Orders> orders;
	
}
