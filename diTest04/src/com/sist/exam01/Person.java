package com.sist.exam01;

public class Person {
	/*
	public Person() {
		System.out.println("생성자 동작함");
	}
	*/
	public Person(String name) {
	}
	//사용자가 매개변수를 갖는 생성자를 만들게 되면 
	//자바는 더이상 기본 생성자를 제공하지 않음
	//필요하다면 사용자가 만들어야 함
	
	public void sayHello() {
		System.out.println("hello");
	}
}
