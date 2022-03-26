package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {

	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void mypoint() {}
	
	@Before("mypoint()")
	public void before() {
		System.out.println("타켓메소드가 동작하기 전입니다");
	}
}