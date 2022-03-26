package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;

@Service
@Setter
public class SendPhoneService {
	
	@Autowired
	private MemberDAO dao;
	
	public void sendMsg() {
		List<MemberVO> list = dao.selectMember();
		BitSms sms = new BitSms();
		Date today = new Date();
		int hours = today.getHours();
		String ampm = "오전";
		if(hours >=12) {
			ampm = "오후";
		}
		for(MemberVO m : list) {
			String from = "01025598279";
			String to = m.getPhone();
			String name = m.getName();
			String msg = name+"님, "+ampm+"에 코로나 자가진단을 해주십시오 [담당자:김지현]";
			sms.sendMsg(from, to, msg);
			System.out.println(name+ "님에게 메세지를 전송하였습니다.");
	
		}
	System.out.println("메세지를 모두 전송 하였습니다");
		
		
	}
	
	
	
		
	
}
