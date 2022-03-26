package com.sist.exam01;

public class Person {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("매개변수를 갖는 생성자 동작함");
	}
	//사용자가 매개변수를 갖는 생성자를 만들게 되면 
	//자바는 더이상 기본 생성자를 제공하지 않음
	//필요하다면 사용자가 만들어야 함
	
	
	
	public void sayHello() {
		System.out.println("hello, "+name);
	}
}
