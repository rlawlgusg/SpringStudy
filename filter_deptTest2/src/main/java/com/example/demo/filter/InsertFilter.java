package com.example.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class InsertFilter
 */
//@WebFilter("/InsertFilter")
@Component
public class InsertFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public InsertFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	//필터를 설정하면 필터클래스의 doFilter메소드가 동작함
	//필터가 해야하는 일을 doFilter메소드에 작성
	//doFilter메소드는 request,response,FilterChain을 매개변수로 갖음
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//이 필터에서 해야 하는 일은
		//로그인 했는지 파악하는 일임
		//로그인 했는지 파악하기 위해서는 session이 필요함
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		//request객체를 통하여 session객체를 받아옴
		//필터 메소드의 매개변수인 request는 ServeletRequest라서 바로 session을 얻어 올 수 없고
		//이것의 자식 클래스인 HttpServletRequest로 캐스팅하여 session을 얻어올 수 있음
		
		int re = -1;
		//세션에 로그인과 관련한 값을 읽어와서 저장할 변수를 선언함
		
		if(session.getAttribute("re")!=null) {
			re = (Integer)session.getAttribute("re");
		}
		//세션에 로그인과 관련한 re값이 있다면 읽어와서 변수에 저장함
		
		if(re == 1) {	//세션에 저장된 re값이 1이라면, 즉 로그인을 하였다면
			chain.doFilter(request, response); //요청한 서비스로 이동시킴
		}else {			//세션에 저장된 re값이 1이 아니라면(로그인을 하지 않았다면)
			((HttpServletResponse)response).sendRedirect("/login");//로그인 페이지로 이동시킴
		}
		
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
