package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SistConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) { //addInterceptors 메소드로 오버라이딩 하여
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LoginInterceptor())	//매개변수 registry 인터셉터를 등록함
		.addPathPatterns("/insertDept.do","/member/**");//insertDept.do와 member에 모든 요청일 때에 인터셉터가 동작하도록 설정
		
		registry.addInterceptor(new AdminInterceptor())
		.addPathPatterns("/admin/**");
		
		registry.addInterceptor(new DeptLogInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/login");
	}

}
