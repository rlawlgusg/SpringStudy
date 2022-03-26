package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//인증과 인가를 위하여 
//스프링시큐리티가 제공하는 WebSecurityConfigurerAdapter를 상속받은 클래스를 만듬
//configure라는 메소드를 오버라이딩하여 시큐리티 환경설정을 해줌
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//configure메소드의 HttpSecurity의 http매개변수를 통해 환경설정함
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	
			http.authorizeHttpRequests()
			.mvcMatchers("/","/join","/login","/all/**").permitAll() //인증(로그인)을 하지 않아도될 서비스를 설정함
			.mvcMatchers("/admin/**").hasRole("admin") //admin네임스페이스에 있는 모든 요청은 admin 권한이 있어야 가능함(인가)
			.anyRequest().authenticated();//나머지 모든 요청은 인증(로그인)을 해야 서비스를 받을 수 있음
			//스프링시큐리티를 사용하겠다고 의존관계를 설정하면
			//스프링시큐리티가 로그인폼을 제공해줌
			
			//만약, 자신이 만든 로그인폼을 사용하려면 다음과 같이 설정함
			http.formLogin().loginPage("/login")//로그인을 위한 서비스명을 설정함
			.defaultSuccessUrl("/loginOK");
			//로그인을 성공하였을 때에 이동할 서비스명을 설정 
			//→로그인을 성공했을 때 이동하는 컨트롤러에서 로그인한 회원의 정보를 상태유지하는 코드를 작성함
			
			//이때에 로그인을 위한 get방식에 대한 컨트롤러와 viewPage까지만 사용자가 만들어줌
			//login에 대한 Post방식에 대한 처리는 사용자가 따로 하지 않음
			//이것은 스프링 시큐리티가 처리함
			//로그인을 위한 폼태그에서 아이디와 암호를 입력하고 submit버튼을 누르면
			//UserDetailService인터페이스를 구현한 클래스의 loadUserByUsername메소드가 
			//자동으로 동작함 
			
			//로그아웃을 위하여 서비스명만 설정하면
			//실제로그아웃에 대한 처리는 스프링시큐리티가 처리해줌
			http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃을 위한 서비스명을 설정함
			.invalidateHttpSession(true) //로그아웃을 완료하였을 때 세션을 파기 하도록 설정함
			.logoutSuccessUrl("/login"); //로그아웃을 완료한 후에 이동할 서비스명을 설정함
			
			http.httpBasic(); //나머지 사항들을 http기본을 따르도록 설정함
	}
}
