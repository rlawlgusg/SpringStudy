package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component
public class SistInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500);
		System.out.println("요청처리 전입니다.");
		Thread.sleep(500);
		return super.preHandle(request, response, handler);
		//사용자의 상황에 따라 흐름을 제어하는 용도로 인터셉터를 사용한다면
		//사용자의 요청으로 이동시키지 않으려면 false를 반환함
		//사용자의 요청으로 이동시키려면 다음의 메소드를 호출한 결과를 반환함
		//return super.preHandle(request,response,handler)
		//매개변수 request를 통해서 사용자의 정보를 파악할 수 있음 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500);
		System.out.println("요청메소드 진입입니다");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("뷰로 가기 직전입니다");
		super.afterCompletion(request, response, handler, ex);
		//이 메소드는 뷰로 이동하기 직전에 동작하는 메소드임
		//만약 흐름을 제어하는 용도로 쓴다면 적합치 않음
		//이미 요청에 따른 컨트롤러의 메소드안의 내용은 모두 수행한 시점임
		
		//만약, Log를 남기는 용도로 인터셉터를 사용한다면
		//어떤 메소드를 사용해도 관계가 없으나 
		//흐름을 제어하는 용도로 사용한다면
		//preHandle 메소드를 사용하기를 권장함
	}

}
