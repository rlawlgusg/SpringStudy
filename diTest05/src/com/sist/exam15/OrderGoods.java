package com.sist.exam15;

public class OrderGoods {
	private String customer;
	private GoodsVO goodsVO;
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}
	
	public void order() {
		System.out.println(customer+"���� �ֹ��� ��ǰ�� ������ �����ϴ�");
		goodsVO.info();
	}
}
