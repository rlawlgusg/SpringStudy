package com.sist.exam14;

public class GoodsVO {
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	
	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public void info() {
		System.out.println("��ǰ��ȣ : "+no);
		System.out.println("��ǰ�̸� : "+name);
		System.out.println("��ǰ���� : "+price);
		System.out.println("��ǰ���� : "+qty);
		System.out.println("��ǰ���� : "+fname);
	}
}
