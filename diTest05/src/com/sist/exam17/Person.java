package com.sist.exam17;

public class Person {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("생성자 동작함");
	}
	
	
	public void sayHello() {
		System.out.println("hello, "+name);
	}
}
