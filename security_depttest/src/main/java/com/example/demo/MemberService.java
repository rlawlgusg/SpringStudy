package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVO;

import lombok.Setter;
@Service
@Setter
public class MemberService implements UserDetailsService{
	
	@Autowired
	private MemberDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//UserDetail을 만들려면 아이디,암호,롤이 필요함
		MemberVO m = dao.findById(username);
		UserDetails userDetails = null;
		
		if(m == null) {
			throw new UsernameNotFoundException(username);
		}
		//UserDetails를 생성하기 위해서 UserBuilder가 필요함
		//userDetails = User.builder().username(username).password(m.getPwd()).roles(m.getRole()).build();
		
		//UserBuilder builder = User.builder();
		//builder.username(username); //아이디를 설정
		//builder.password(m.getPwd()); //암호를 설정
		//builder.roles(m.getRole());	//롤을 설정
		//userDetails = builder.build();	//아이디,암호,롤이 설정된 UserBuilder를 갖고 UserDetails를 생성함
		//return userDetails;
		
		return User.builder().username(username).password(m.getPwd()).roles(m.getRole()).build();
	}


}
