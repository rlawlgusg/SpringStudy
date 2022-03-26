package com.example.test0315_jpa_book.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Orders {
	
	@Id
	private int orderid;
	
	@ManyToOne
	@JoinColumn(name = "bookid", insertable = true, updatable = true)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "custid", insertable = true, updatable = true)
	private Customer customer;
	
	private int saleprice;
	private String orderdate;


}
