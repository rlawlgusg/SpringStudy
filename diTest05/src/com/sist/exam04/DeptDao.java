package com.sist.exam04;

public class DeptDao {
	private Dept dept;

	public DeptDao(Dept dept) {
		super();
		this.dept = dept;
	}
	
	public void insert() {
		System.out.println("������ �μ��� ����Ͽ����ϴ�");
		System.out.println(dept);
	}
}
