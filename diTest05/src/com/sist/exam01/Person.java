package com.sist.exam01;

public class Person {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("�Ű������� ���� ������ ������");
	}
	//����ڰ� �Ű������� ���� �����ڸ� ����� �Ǹ� 
	//�ڹٴ� ���̻� �⺻ �����ڸ� �������� ����
	//�ʿ��ϴٸ� ����ڰ� ������ ��
	
	
	
	public void sayHello() {
		System.out.println("hello, "+name);
	}
}
