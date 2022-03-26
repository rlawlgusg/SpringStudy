package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.filter.MemberFilter;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
	
	@Bean
	public FilterRegistrationBean setFilterRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MemberFilter());
		filterRegistrationBean.addUrlPatterns("/member/*");
		return filterRegistrationBean;
	}
}
