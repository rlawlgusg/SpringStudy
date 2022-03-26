package com.example.demo.advice;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ExcepLogDAO;
import com.example.demo.vo.ExceptionLog;

import lombok.Setter;
@Setter
@Component
@Aspect
public class ControllerErrorAdvice {
	
	@Autowired
	public ExcepLogDAO dao;
	
	

	@AfterThrowing(pointcut = "execution(public * com.example.demo.controller..*(..))" ,throwing = "e")
	public void pro(JoinPoint joinPoint, Exception e) {
		System.out.println("타깃 메소드에서 오류가 발생하고 종료되었습니다.");
		HttpServletRequest request= (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		System.out.println("uri:"+uri);
		System.out.println("ip:"+ip);
		
		String msg = e.getMessage();
		//System.out.println(msg);
		int start =  msg.indexOf("ORA");
		int end = msg.indexOf(":", start);
		String errorCode =  msg.substring(start, end);
		System.out.println("errorCode:"+errorCode);
		
		ExceptionLog log = new ExceptionLog();
		log.setIp(ip);
		log.setUri(uri);
		log.setError_code(errorCode);
		
		dao.insert(log);
		
		System.out.println("--------------------------------------------");
		
		
	}
}
