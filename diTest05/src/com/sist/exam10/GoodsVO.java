package com.sist.exam10;

public class GoodsVO {
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	


	public GoodsVO(int no, String name, int price, int qty, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
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
