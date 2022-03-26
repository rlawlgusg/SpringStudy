package com.sist.exam10;

public class OrderGoods {
	private String customer;
	private GoodsVO goodsVO;
	
	public OrderGoods(String customer, GoodsVO goodsVO) {
		super();
		this.customer = customer;
		this.goodsVO = goodsVO;
	}
	
	public void order() {
		System.out.println(customer+"���� ������ ��ǰ�� ������ ������ �����ϴ�");
		goodsVO.info();
	}
}
